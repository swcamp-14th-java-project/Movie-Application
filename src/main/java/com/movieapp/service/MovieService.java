package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.aggregate.Theater;
import com.movieapp.repository.MovieRepository;

import java.time.LocalDate;
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
        Scanner sc = new Scanner(System.in);
        if(filter == null)
            return;
        int mainFilter = filter[0];
        MovieInfo movieInfo = null;
        LocalDate localDate = null;

        ArrayList<MovieSchedule> findMovie = new ArrayList<>();
        ArrayList<MovieInfo> movieName = new ArrayList<>();

        switch (filter[0]) {
            case 0:
                // 네임 말고 전부 조회
                movieName = mr.selectAllMovie();
                movieName.forEach(System.out::println);
                break;
            // 극장별
            case 1:
                Theater theater = Theater.values()[filter[1] - 1];
                System.out.println("선택한 극장: " + theater);
                findMovie = mr.selectByTheater(theater);
                break;
            // 영화별
            case 2:
                movieName = mr.selectAllMovie();
                movieInfo = movieName.get(filter[1] - 1);
                System.out.println("movieInfo = " + movieInfo);
                findMovie = mr.selectByMovie(movieInfo.getMovieName());
                break;
            // 날짜별
            case 3:
                String date = "2025-02-" + filter[1];
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println(localDate + "일의 영화 목록");
                findMovie = mr.selectByDate(localDate);
                break;
        }
        findMovie.forEach(System.out::println);
    }
}
