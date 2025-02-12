package com.movieapp.aggregate;

public enum ScreenType {
    TWOD("2D"),
    THREED("3D"),
    FOURD("4D"),
    SCREENX("ScreenX");

    private String screenType;

    // 생성자 (싱글톤)
    ScreenType(String screenType) {
        this.screenType = screenType;
    }

    // Getter
    public String getScreenType() {
        return screenType;
    }

}
