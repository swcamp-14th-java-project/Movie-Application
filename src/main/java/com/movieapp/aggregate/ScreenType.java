package com.movieapp.aggregate;

public enum ScreenType {
    TWOD("2D"),
    THREED("3D"),
    FOURDX("4DX"),
    SCREENX("ScreenX"),
    IMAX("Imax");

    String screenType;
    ScreenType(String screenType) {
        this.screenType = screenType;
    }

    @Override
    public String toString() {
        return screenType;
    }
}
