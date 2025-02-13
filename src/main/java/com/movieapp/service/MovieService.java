package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();

    public MovieService() {
        System.out.println("MovieService 생성");
    }
  
    public void showAllMovies() {
        }

    public void cancelReservation() {

    }
}
