package com.movieapp.aggregate;

public enum ScreenType {
    TWOD("2D"),
    THREED("3D"),
    FOURDX("4DX"),
    SCREENX("ScreenX");

    String screenType;
    ScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }
}
