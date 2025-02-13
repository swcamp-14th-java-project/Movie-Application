package com.movieapp.service;

import com.movieapp.repository.MovieRepository;

public class MovieService {
    private final MovieRepository mr = new MovieRepository();

    public MovieService() {
        System.out.println("MovieService 생성");
    }
}
