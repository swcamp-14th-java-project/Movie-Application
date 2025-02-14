package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.aggregate.Theater;
import com.movieapp.repository.MovieRepository;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();

    public MovieService() {
        System.out.println("MovieService 생성");
    }

    // 영화 상영 스케줄 표 보기
    public void showMovieSchedule(int[] scheduleFilter) {
        int firstFilter = scheduleFilter[0];
        int secondFilter = scheduleFilter[1];

        List<MovieSchedule> filteredSchedules = new ArrayList<>();

        switch (firstFilter) {
            case 1: // 전체 상영 스케줄표 조회
                showAllSchedule();
                break;
            case 2: // 극장 별로 조회
                Theater theater = null;
                Theater[] theaters = Theater.values();
                theater = theaters[secondFilter - 1];   // 극장 이름 받음.
                System.out.println(theater);
                filteredSchedules = mr.selectTheaterSchedule(theater);
                break;
            case 3:     // 영화 별로 조회
                filteredSchedules = mr.selectedMovieInfoSchedule(secondFilter);
                break;
            case 4:     // 날짜별로 조회 (ex. 2025-02-16)
                int days = secondFilter + 11; // 12일 ~ 19일
                System.out.println(days);
                LocalDate selectedDate = LocalDate.of(2025, 2, days);
                filteredSchedules = mr.selectedDateSchedule(selectedDate);
                break;

            default:
                System.out.println("번호를 잘못 입력하셨습니다.");
        }
        for(MovieSchedule movieSchedule : filteredSchedules) {
            System.out.println(movieSchedule.getDate() + " " + movieSchedule.getScheduleNo() + ". " + movieSchedule.getMovieInfo().getMovieName()
                    + " " + movieSchedule.getTheaterName() + " " + movieSchedule.getEmptySeats());
        }

        System.out.println("\uD83D\uDD19 메인으로 돌아가기");

    }

    // 전체 영화 목록 조회
    public  void showAllMovies() {
        List<MovieInfo> allMovies = mr.selectAllMovies();

        System.out.println(allMovies.toString());
        for(MovieInfo movieInfo : allMovies) {
            System.out.println(movieInfo.getMovieNo() + ". " + movieInfo.getMovieName());
        }

    }

    // 전체 상영 스케줄표를 조회
    public void showAllSchedule() {
        List<MovieSchedule> allSchedules = mr.selectAllSchedules();

        System.out.println(allSchedules.toString());
        for(MovieSchedule movieSchedule : allSchedules) {
            System.out.println(movieSchedule.getDate() + " " + movieSchedule.getScheduleNo() + ". " + movieSchedule.getMovieInfo().getMovieName()
            + " " + movieSchedule.getTheaterName() + " " + movieSchedule.getEmptySeats());
        }
    }
}
