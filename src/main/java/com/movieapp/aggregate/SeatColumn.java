package com.movieapp.aggregate;

public enum SeatColumn {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    int seatColumn;
    SeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public static SeatColumn fromInt(int column) {
        for (SeatColumn seat : SeatColumn.values()) {
            if (seat.getSeatColumn() == column) {
                return seat;
            }
        }
        return null; // 해당하는 값이 없으면 null 반환
    }
}