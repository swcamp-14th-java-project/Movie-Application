package com.movieapp.aggregate;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieSchedule {
    private int movieNo;            // 영화 번호
    private int scheduleNo;         // 상영 번호
    private Theater theaterName;    // 극장
    private LocalDate date;         // 상영날짜 (월, 일)
    private LocalTime startTime;    // 상영 시작 시간 (시, 분)
    private int emptySeats;         // 잔여 좌석 수
    private ScreenType screenType;  // 스크린 타입

    public MovieSchedule() {
    }

    public MovieSchedule(int movieNo, int scheduleNo, Theater theaterName, LocalDate date, LocalTime startTime, int emptySeats, ScreenType screenType) {
        this.movieNo = movieNo;
        this.scheduleNo = scheduleNo;
        this.theaterName = theaterName;
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

    public int getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(int scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public Theater getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(Theater theaterName) {
        this.theaterName = theaterName;
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
        return "MovieSchedule{" +
                "movieNo=" + movieNo +
                ", scheduleNo=" + scheduleNo +
                ", theaterName=" + theaterName +
                ", date=" + date +
                ", startTime=" + startTime +
                ", emptySeats=" + emptySeats +
                ", screenType=" + screenType +
                '}';
    }
}
