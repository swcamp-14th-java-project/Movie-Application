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
      
    }

    public void findMovieSchedule(int[] filter) {
        Scanner sc = new Scanner(System.in);
        if(filter == null)
            return;
        int mainFilter = filter[0];
        Theater theater = null;
        MovieInfo movieInfo = null;
        LocalDate localDate = null;

        ArrayList<MovieSchedule> findMovie = new ArrayList<>();
        ArrayList<MovieInfo> movieName = new ArrayList<>();

        switch (filter[0]) {
            case 0:
                movieName = mr.selectAllMovie();
                movieName.forEach(System.out::println);
            // 극장별
            case 1:
                switch (filter[1]) {
                    case 1:
                        theater = Theater.GANGNAM;
                        break;
                    case 2:
                        theater = Theater.KONKKUK;
                        break;
                    case 3:
                        theater = Theater.APGUJEONG;
                        break;
                    case 4:
                        theater = Theater.IPARK;
                        break;
                }
                findMovie = mr.selectByTheater(theater);
                break;
            // 영화별
            case 2:
                movieName = mr.selectAllMovie();
                movieName.forEach(System.out::println);
                movieInfo = movieName.get(filter[1] - 1);
                System.out.println("movieInfo = " + movieInfo);
                findMovie = mr.selectByMovie(movieInfo.getMovieName());
                break;
            // 날짜별
            case 3:
                String date = "2025-02-" + filter[1];
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("date = " + date);
                System.out.println("localDate = " + localDate);
                findMovie = mr.selectByDate(localDate);
                break;
        }
        findMovie.forEach(System.out::println);
    }
}
