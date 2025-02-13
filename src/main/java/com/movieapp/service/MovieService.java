package com.movieapp.service;

import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.aggregate.Theater;
import com.movieapp.repository.MovieRepository;

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

    public void findMovieSchedule() {
        Scanner sc = new Scanner(System.in);
        int theaterNum = 1;
        int MovieNum = 1;
        int DateNum = 1;
//        ArrayList<MovieSchedule> findMovie = mr.selectByTheater(theaterNum);
//        ArrayList<MovieSchedule> findMovie = mr.selectByMovie(MovieNum);
    }
}
