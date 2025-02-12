package com.movieapp.aggregate;

import java.io.Serializable;

public class Ticket implements Serializable {
    private int movieNo; // 영화 등록 번호
    private int numPeople;
    private SeatColumn seatColumn;
    private SeatRow seatRow;
}
