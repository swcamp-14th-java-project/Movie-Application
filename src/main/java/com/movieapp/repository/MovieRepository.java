package com.movieapp.repository;

import com.movieapp.aggregate.Movie;
import com.movieapp.aggregate.Ticket;

import java.io.File;
import java.util.ArrayList;

public class MovieRepository {
    /* 설명. 프로그램이 실행될 때
    *   영화 상영 스케줄 데이터가 없으면 새로 생성됨
    * */
    
    // MovieRepository에서 관리할 "영화상영스케줄", "예매내역목록" 컬렉션
    private final ArrayList<Movie> movieSchedule = new ArrayList<>();   // 영화 상영스케줄표 목록
    private final ArrayList<Ticket> ticketList = new ArrayList<>();     // 예매 내역 목록

    // 영황 상영 스케줄표가 저장되어 있는 파일
    private final File movieFile =
            new File("src/main/java/com/movieapp/db/movieDB.dat");

    // 기본 생성자
    public MovieRepository() {
        int movieCounter = 1;   // 영화 등록 번호 자동으로 생성

        if(!movieFile.exists()) {
            // 파일이 존재하지 않으면 생성됨
            ArrayList<Movie> defaultMovies = new ArrayList<>();
            defaultMovies.add(new Movie(movieCounter++, "", "말할 수 없는 비밀", 4.95, 장르, 등급, 180, LocalTime()   ));

        }

        loadMovies();   // 영화 상영 스케줄표 목록 읽어오기
    }

    private void loadMovies() {
    }
}
