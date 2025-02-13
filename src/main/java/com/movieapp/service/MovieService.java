package com.movieapp.service;

import com.movieapp.aggregate.MovieInfo;
import com.movieapp.aggregate.MovieSchedule;
import com.movieapp.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {

    private final MovieRepository mr = new MovieRepository();
    private List<MovieInfo> movieInfo = mr.getAllMovieInfo(); // 영화 정보
    private List<MovieSchedule> movieSchedule = mr.getAllMovieSchedule();

    public MovieService() {
        System.out.println("MovieService 생성");
    }

    // 현재 상영중인 영화의 번호, 제목 출력
    public void showAllMovies() {


        System.out.println("===== 현재 상영중인 영화입니다 ===== ");
        for (MovieInfo movieinfo : movieInfo) {
            System.out.println("[영화 번호] " + movieinfo.getMovieNo() + ", [제목] " + movieinfo.getMovieName());
        }
    }

    // 티켓 예매
    public void ticketReservation() {
        showAllMovies();

        Scanner sc = new Scanner(System.in);
        System.out.print("예매할 영화 번호를 선택해주세요: ");
        int movieNo = sc.nextInt();

//        System.out.println(movieInfo.get(movieNo-1)); // 사용자가 선택한 영화 정보 출력

        System.out.println("===== 해당 영화의 상영 스케줄입니다 ===== ");

        // 해당 번호의 영화스케줄을 불러와야함. 함수를 따로 작성해야 할듯.
        for(MovieSchedule movieSchedule : movieSchedule) {
            System.out.println("[스케줄]" + movieSchedule.getScreenType());
        }



    }
}