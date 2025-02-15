package com.movieapp.aggregate;

import java.io.Serializable;

public class Ticket implements Serializable {
    private MovieSchedule movieSchedule;
    private int ticketNo;   // 예매 등록 번호
    private int movieNo; // 영화 등록 번호
    private int numPeople; // 인원 수
    private SeatColumn seatColumn; // 좌석 열
    private SeatRow seatRow; // 좌석 행
    private int price; // 가격

    public Ticket() {
    }


    public Ticket(MovieSchedule movieSchedule, int ticketNo, int movieNo, int numPeople, SeatColumn seatColumn, SeatRow seatRow, int price) {
        this.movieSchedule = movieSchedule;
        this.ticketNo = ticketNo;
        this.movieNo = movieNo;
        this.numPeople = numPeople;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.price = price;
    }

//    public Ticket(int ticketNo, int movieNo, int numPeople, SeatColumn seatColumn, SeatRow seatRow, int price) {
//        this.ticketNo = ticketNo;
//        this.movieNo = movieNo;
//        this.numPeople = numPeople;
//        this.seatColumn = seatColumn;
//        this.seatRow = seatRow;
//        this.price = price;
//    }

    public String getMovieName() {
        return movieSchedule.getMovieInfo().getMovieName();
    }

    public int getTicketNo() { return ticketNo; }

    public void setTicketNo(int ticketNo) { this.ticketNo = ticketNo; }

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
        return  "[예매 번호] " + ticketNo +
                " [영화 제목] " + getMovieName() +
                " [인원 수] " + numPeople +
                " [좌석 열] " + seatRow +
                " [좌석 번호] " + getSeatColumn().getSeatColumn() +
                " [가격] " + price;
    }
}