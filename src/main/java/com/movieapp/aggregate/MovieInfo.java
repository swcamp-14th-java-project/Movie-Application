package com.movieapp.aggregate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class MovieInfo implements Serializable {
    private int movieNo;            // 영화 고유 번호
    private String movieName;       // 영화 이름
    private double movieRating;     // 영화 평점
    private MovieGenre movieGenre;  // 영화 장르
    private MovieGrade movieGrade;  // 상영 등급
    private int runningTime;        // 러닝 타임(분)


    
    // 기본 생성자
    public MovieInfo() {
    }

    public MovieInfo(int movieNo, String movieName, double movieRating, MovieGenre movieGenre, MovieGrade movieGrade, int runningTime) {
        this.movieNo = movieNo;
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieGenre = movieGenre;
        this.movieGrade = movieGrade;
        this.runningTime = runningTime;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public MovieGrade getMovieGrade() {
        return movieGrade;
    }

    public void setMovieGrade(MovieGrade movieGrade) {
        this.movieGrade = movieGrade;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "movieNo=" + movieNo +
                ", movieName='" + movieName + '\'' +
                ", movieRating=" + movieRating +
                ", movieGenre=" + movieGenre +
                ", movieGrade=" + movieGrade +
                ", runningTime=" + runningTime +
                '}';
    }
}
