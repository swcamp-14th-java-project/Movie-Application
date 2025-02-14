package com.movieapp.aggregate;

public enum MovieGenre {
    ACTION("액션"),
    ROMANCE("로맨스"),
    THRILLER("스릴러"),
    ANIMATION("애니메이션"),
    HISTORY("시대극"),
    MELO("멜로"),
    MYSTERY ("미스터리"),
    DRAMA("드라마");

    private String genre;

    MovieGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return genre;
    }
}
