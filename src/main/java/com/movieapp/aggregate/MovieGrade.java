package com.movieapp.aggregate;

public enum MovieGrade {
    ALL("전체 관람가"),
    TWELVE("12세"),
    FIFTHTEEN("15세"),
    NINETEEN("청소년 관람불가");

    String movieGrade;

    MovieGrade(String movieGrade) {
        this.movieGrade = movieGrade;
    }

    public String getMovieGrade() {
        return movieGrade;
    }
}
