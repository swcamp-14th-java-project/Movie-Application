package com.movieapp.aggregate;

public enum SeatRow {
    A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G"), H("H");
    String seatRow;
    private SeatRow(String seatRow) {
        this.seatRow = seatRow;
    }
}
