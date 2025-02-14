package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.repository.MovieRepository;
import java.util.List;
import java.util.Scanner;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();
    private List<MovieInfo> movieInfo = mr.getAllMovieInfo(); // 영화 정보
    private List<MovieSchedule> movieSchedule = mr.getAllMovieSchedule(); // 영화 상영 정보

    Scanner sc = new Scanner(System.in);

    public MovieService() {
        System.out.println("MovieService 생성");
    }

    // 현재 상영중인 영화의 번호, 제목 출력
    public void showAllMovies() {

        System.out.println("===== 현재 상영중인 영화입니다 ===== ");
        for (MovieInfo movieinfo : movieInfo) {
            System.out.println("[영화 번호] " + movieinfo.getMovieNo() + ", [제목] " + movieinfo.getMovieName());
        }

    }
    private void showAllMovieSchedule() {
        System.out.print("예매할 영화 번호를 선택해주세요: ");
        int movieNo = sc.nextInt();

        System.out.println("===== 해당 영화의 상영 스케줄입니다 ===== ");

        for(MovieSchedule movieschedule : movieSchedule) {
            if(movieschedule.getMovieInfo().getMovieNo() == movieNo) {
                System.out.println("[영화 제목] " + movieschedule.getMovieInfo().getMovieName() +  ", [상영 번호] " + movieschedule.getScheduleNo() + ", [상영관] " + movieschedule.getTheaterName().toString()
                        + ", [상영 날짜] " + movieschedule.getDate() + ", [상영 시각] " + movieschedule.getStartTime()
                        + ", [잔여 좌석 수] " + movieschedule.getEmptySeats() + ", [스크린 타입] " + movieschedule.getScreenType().toString());
            };
        }
    }

    // 티켓 예매
    public void ticketReservation() {
        showAllMovies();
        showAllMovieSchedule();

        // 티켓 객체를 만들어서 티켓 발행. 인원 수
        System.out.print("예매하고싶은 영화 상영 번호를 입력해주세요: ");
        int scheduleNo = sc.nextInt();

        System.out.print("인원 수를 선택해주세요: ");
        int numPeople = sc.nextInt();

        System.out.println("좌석을 선택해주세요");
        for (int i = 0; i < numPeople; i++) {

        }
    }

}
