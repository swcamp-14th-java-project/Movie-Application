package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.repository.MovieRepository;

import java.sql.SQLOutput;
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

        switch (firstFilter) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }






    }

    public  void showAllMovies() {
        List<MovieInfo> allMovies = mr.selectAllMovies();

        System.out.println("Service에서 조회 확인: ");
        System.out.println(allMovies.toString());
        for(MovieInfo movieInfo : allMovies) {
            System.out.println(movieInfo.getMovieNo() + ". " + movieInfo.getMovieName());
        }

    }
}
