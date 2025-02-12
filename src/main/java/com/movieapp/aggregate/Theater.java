package com.movieapp.aggregate;

public enum Theater {
    GANGNAM("CGV 강남"),
    KONKKUK("CGV 건대입구"),
    APGUJEONG("CGV 압구정"),
    IPARK("CGV 용산 아이파크몰");

    String theater;

    Theater(String theater) {
        this.theater = theater;
    }

    public String getTheater() {
        return theater;
    }
}
