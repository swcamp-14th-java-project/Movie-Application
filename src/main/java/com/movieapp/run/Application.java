package com.movieapp.run;

import com.movieapp.aggregate.Theater;
import com.movieapp.service.MovieService;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    private static final MovieService ms = new MovieService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== CGV에 오신 것을 환영합니다! =====");
            System.out.println("1. 영화 상영 정보 보기");
            System.out.println("2. 티켓 예매하기");
            System.out.println("3. 예매 내역 조회하기");
            System.out.println("4. 예매 내역 변경하기");
            System.out.println("5. 예매 취소하기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ms.findMovieSchedule(chooseFilter());
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("CGV 예매 프로그램을 종료합니다. 안녕히 가세요");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다");
            }
        }
    }

    private static int[] chooseFilter() {
        Scanner sc = new Scanner(System.in);
        int mainFilter = 0;
        int subFilter = 0;

        System.out.println("영화 상영 정보 조회 메뉴");
        System.out.println("0. 전제 영화 상영 정보 조회");
        System.out.println("1. 극장 별로 조회");
        System.out.println("2. 영화 별로 조회");
        System.out.println("3. 날짜 별로 조회");
        System.out.println("9. 메인 메뉴로 돌아가기");
        System.out.print("메뉴 선택: ");

        int input = sc.nextInt();
        if (input == 9){
            return null;
        } else {
            mainFilter = input;
        }
        if(mainFilter > 0 && mainFilter < 4)
            subFilter = deepFilter(mainFilter);
        else if(mainFilter == 0)
            subFilter = 1;
        else
            return null;


        return new int[]{mainFilter, subFilter};
    }

    private static int deepFilter(int mainFilter) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        switch(mainFilter){
            // 극장 별로 조회
            case 1:
                // 극장 목록 출력
                Stream.of(Theater.values()).forEach(t -> System.out.println((t.ordinal()+1) + ". " + t));
                System.out.print("극장 번호 입력: ");
                break;
            // 영화 별로 조회
            case 2:
                // 영화 목록 출력
                ms.showAllMovies();
                System.out.print("영화 번호 입력: ");
                break;
            // 날짜별로 조회
            case 3:
                // 날짜 출력
                IntStream intStream = IntStream.range(12, 20);
                intStream.forEach(d -> System.out.println("2025년 02월 " + d + "일"));
                System.out.print("날짜 입력(일): ");
                break;
            default:
                System.out.println("번호를 잘못 입력하였습니다.");
                System.out.println("메인 메뉴로 돌아갑니다.");
                return -1;
        }
        result = sc.nextInt();
        return result;
    }
}
