
package com.movieapp.service;


import com.movieapp.aggregate.*;
import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.aggregate.Theater;


import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.repository.MovieRepository;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();

    public MovieService() {
        System.out.println("MovieService 생성");
    }

    // 영화 상영 스케줄 표 보기
    public void showMovieSchedule(int[] scheduleFilter) {
        if (scheduleFilter == null) {
            System.out.println("\uD83D\uDD19 메인으로 돌아가기");
            return;
        }
        int mainFilter = scheduleFilter[0];
        int subFilter = scheduleFilter[1];


        List<MovieSchedule> filteredSchedules = new ArrayList<>();

        switch (mainFilter) {
            case 1: // 전체 상영 스케줄표 조회
                System.out.println("======= 전체 상영 스케줄 표 =======");
                filteredSchedules = mr.selectAllSchedules();
                break;
            case 2: // 극장 별로 조회
                if (subFilter > Theater.values().length) {
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    System.out.println("\uD83D\uDD19 메인으로 돌아가기");
                    return;
                }
                System.out.println("======= 극장별 스케줄 표 =======");
                Theater theater = null;
                Theater[] theaters = Theater.values();
                theater = theaters[subFilter - 1];   // 극장 이름 받음.
                filteredSchedules = mr.selectTheaterSchedule(theater);
                break;
            case 3:     // 영화 별로 조회
                int movieSize = mr.selectAllMovies().size();
                if (subFilter > movieSize) {
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    System.out.println("\uD83D\uDD19 메인으로 돌아가기");
                    return;
                }
                System.out.println("======= 영화별 스케줄 표 =======");
                filteredSchedules = mr.selectedMovieInfoSchedule(subFilter);
                break;
            case 4:     // 날짜별로 조회 (ex. 2025-02-16)
                int lastDayOfMonth = YearMonth.of(2025, 2).lengthOfMonth();
                int day = Math.min(subFilter + 11, lastDayOfMonth);
                LocalDate selectedDate = LocalDate.of(2025, 2, day);
                System.out.println("======= " + selectedDate + "스케줄 표 =======");
                filteredSchedules = mr.selectedDateSchedule(selectedDate);
                break;

        }

        if (!filteredSchedules.isEmpty()) {
            for (MovieSchedule movieSchedule : filteredSchedules) {
                System.out.println("[날짜] " + movieSchedule.getDate() + " [상영 번호] " + movieSchedule.getScheduleNo() + " [영화 제목] " + movieSchedule.getMovieInfo().getMovieName()
                        + " [극장] " + movieSchedule.getTheaterName() + " [잔여 좌석수] " + movieSchedule.getEmptySeats());
            }
        } else {
            System.out.println("해당하는 영화가 없습니다. ");
        }

        System.out.println();
        System.out.println("\uD83D\uDD19 메인으로 돌아가기");

    }

    // 전체 영화 목록 조회
    public void showAllMovies() {
        List<MovieInfo> allMovies = mr.selectAllMovies();

        for (MovieInfo movieInfo : allMovies) {
            System.out.println(movieInfo.getMovieNo() + ". " + movieInfo.getMovieName());
        }

    }

    // 전체 상영 스케줄표를 조회
    public void showAllSchedule() {
        List<MovieSchedule> allSchedules = mr.selectAllSchedules();

        for (MovieSchedule movieSchedule : allSchedules) {
            System.out.println(movieSchedule.getDate() + " " + movieSchedule.getScheduleNo() + ". " + movieSchedule.getMovieInfo().getMovieName()
                    + " " + movieSchedule.getTheaterName() + " " + movieSchedule.getEmptySeats());
        }
    }

    // 티켓 예매하기
    public void ticketReservation() {
        showAllMovies();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("예매할 영화 번호를 선택해주세요: ");
        int movieNo = sc.nextInt();

        System.out.println("===== 해당 영화의 상영 스케줄입니다 ===== ");

        List<MovieSchedule> filteredSchedules = mr.selectedMovieInfoSchedule(movieNo);

        int index = 1;
        for(MovieSchedule m : filteredSchedules) {
            System.out.println("[상영 번호] " + index + " [영화 제목] " + m.getMovieInfo().getMovieName() + " [극장] "
                    + m.getTheaterName() + " [날짜] " + m.getDate() + " [시작 시간] " + m.getStartTime() + " [잔여 좌석수] "
                    + m.getEmptySeats() + " [스크린 타입] " + m.getScreenType());
            index++;
        }

        System.out.println();
        System.out.print("예매할 영화 상영 번호를 선택해주세요: ");
        int movieSchedulNo = sc.nextInt();
        System.out.print("예매할 인원 수를 선택해주세요: ");
        int people = sc.nextInt();

        System.out.println("선택하신 영화는");
        System.out.println(filteredSchedules.get(movieSchedulNo-1) + " [인원 수] " + people);
        MovieSchedule selectedSchedule = filteredSchedules.get(movieSchedulNo - 1);

        SeatRow[] seatRow = new SeatRow[people];
        SeatColumn[] column = new SeatColumn[people];
        for (int i = 0; i < people; i++) {
            System.out.print((i+1) + "번 째 좌석 열을 선택하세요 (A~H): ");
            seatRow[i] = SeatRow.valueOf(sc.next().toUpperCase());
            sc.nextLine();

            System.out.print((i+1) + "번 째 좌석 번호를 선택하세요 (1~10): ");

            column[i] = SeatColumn.fromInt(sc.nextInt());
            System.out.println("선택한 좌석: " + seatRow[i] + "열 " + column[i].getSeatColumn() + "번");
            System.out.println();
        }

        int price = 15000;

        int lastTicketNum = mr.selectLastTicketNo();
        Ticket[] ticket = new Ticket[people];
        for (int i = 0; i < people; i++) {
            ticket[i] = new Ticket(selectedSchedule,lastTicketNum + 1,
                                    filteredSchedules.get(movieSchedulNo-1).getScheduleNo(),
                                    people, column[i], seatRow[i], price * people);
        }
        System.out.println("티켓이 성공적으로 예매되었습니다! ");

        // movieListDB 에서 예매한 인원 수 만큼 잔여좌석수 감소


        int ticketLength = mr.insertTicket(ticket);
    }

    public void findAllTicket() {
        List<Ticket> findTickets = mr.selectAllTicket();

        System.out.println("예매하신 티켓 내역 확인: ");
        for (Ticket t : findTickets) {
            System.out.println(t);
        }
    }
}
