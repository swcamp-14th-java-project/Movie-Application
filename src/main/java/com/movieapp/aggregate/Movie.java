package com.movieapp.aggregate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Movie implements Serializable {
    private int movieNo;            // 영화 등록 번호
    private Theater theaterName;     // 극장
    private String movieName;       // 영화 이름
    private double movieRating;     // 영화 평점
    private MovieGenre movieGenre;  // 영화 장르
    private MovieGrade movieGrade;  // 상영 등급
    private int runningTime;        // 러닝 타임(분)
    private LocalDate date;         // 상영날짜 (월, 일)
    private LocalTime startTime;    // 상영 시작 시간 (시, 분)
    private int emptySeats;         // 잔여 좌석 수
    private ScreenType screenType;  // 스크린 타입
    
    // 기본 생성자
    public Movie() {
    }
    
    // 모든 매개변수 넣는 생성자
    public Movie(int movieNo, Theater theaterName, String movieName, double movieRating, MovieGenre movieGenre, MovieGrade movieGrade, int runningTime, LocalDate date, LocalTime startTime, int emptySeats, ScreenType screenType) {
        this.movieNo = movieNo;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieGenre = movieGenre;
        this.movieGrade = movieGrade;
        this.runningTime = runningTime;
        this.date = date;
        this.startTime = startTime;
        this.emptySeats = emptySeats;
        this.screenType = screenType;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

    public Theater getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(Theater theaterName) {
        this.theaterName = theaterName;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getEmptySeats() {
        return emptySeats;
    }

    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", theaterName=" + theaterName +
                ", movieName='" + movieName + '\'' +
                ", movieRating=" + movieRating +
                ", movieGenre=" + movieGenre +
                ", movieGrade=" + movieGrade +
                ", runningTime=" + runningTime +
                ", date=" + date +
                ", startTime=" + startTime +
                ", emptySeats=" + emptySeats +
                ", screenType=" + screenType +
                '}';
    }


}
