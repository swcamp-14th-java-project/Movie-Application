package com.movieapp.run;

import com.movieapp.service.MovieService;

import java.util.Scanner;

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
                    ms.findMovieSchedule();
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

    private static void chooseNo() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("영화 상영 정보 조회 메뉴");
            System.out.println("1. 극장 별로 조회");
            System.out.println("2. 영화 별로 조회");
            System.out.println("3. 날짜 별로 조회");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.println("메뉴 선택: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();
            switch (chooseNo) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 9:
                    return;
                default:
                    System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }

}
