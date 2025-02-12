package com.movieapp.aggregate;

import java.io.Serializable;

public class Ticket implements Serializable {
    private int movieNo; // 영화 등록 번호
    private int numPeople; // 인원 수
    private SeatColumn seatColumn; // 좌석 열
    private SeatRow seatRow; // 좌석 행
    private int price; // 가격

    public Ticket() {
    }

    public Ticket(int movieNo, int numPeople, SeatColumn seatColumn, SeatRow seatRow, int price) {
        this.movieNo = movieNo;
        this.numPeople = numPeople;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.price = price;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public SeatColumn getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(SeatColumn seatColumn) {
        this.seatColumn = seatColumn;
    }

    public SeatRow getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(SeatRow seatRow) {
        this.seatRow = seatRow;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieNo=" + movieNo +
                ", numPeople=" + numPeople +
                ", seatColumn=" + seatColumn +
                ", seatRow=" + seatRow +
                ", price=" + price +
                '}';
    }
}
