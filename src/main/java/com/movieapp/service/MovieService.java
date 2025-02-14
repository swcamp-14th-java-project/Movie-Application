package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.aggregate.Theater;
import com.movieapp.repository.MovieRepository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();

    public MovieService() {
        System.out.println("MovieService 생성");
    }
  
    public void showAllMovies() {
        ArrayList<MovieInfo> movieName = mr.selectAllMovie();
        movieName.forEach(System.out::println);
    }

    public void findMovieSchedule(int[] filter) {
        if(filter == null)
            return;

        ArrayList<MovieSchedule> findMovie = null;
        ArrayList<MovieInfo> movieName = null;

        switch (filter[0]) {
            case 0:
                // 네임 말고 전부 조회
                movieName = mr.selectAllMovie();
                movieName.forEach(System.out::println);
                break;
            // 극장별
            case 1:
                if(filter[1] - 1 >= Theater.values().length) {
                    return;
                }
                Theater theater = Theater.values()[filter[1] - 1];
                System.out.println("선택한 극장: " + theater);
                findMovie = mr.selectByTheater(theater);
                break;
            // 영화별
            case 2:
                movieName = mr.selectAllMovie();
                if(filter[1] -1 >= movieName.size()) {
                    return;
                }
                MovieInfo movieInfo = movieName.get(filter[1] - 1);
                System.out.println("선택한 영화: " + movieInfo.getMovieName());
                findMovie = mr.selectByMovie(movieInfo.getMovieName());
                break;
            // 날짜별
            case 3:
                int lastDayOfMonth = YearMonth.of(2025, 2).lengthOfMonth();
                int day = lastDayOfMonth;
                if(filter[1] > lastDayOfMonth)
                    day = lastDayOfMonth;
                else
                    day = filter[1];
                LocalDate localDate = LocalDate.of(2025, 2, day);
                System.out.println(localDate + "일의 영화 목록");
                findMovie = mr.selectByDate(localDate);
                break;
        }
        if(findMovie.size() != 0)
            findMovie.forEach(System.out::println);
        else
            System.out.println("해당하는 영화가 없습니다.");
    }
}
