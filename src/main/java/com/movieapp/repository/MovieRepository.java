package com.movieapp.repository;

import com.movieapp.aggregate.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MovieRepository {
    /* 설명. 프로그램이 실행될 때
    *   영화 상영 스케줄 데이터가 없으면 새로 생성됨
    * */
    
    // MovieRepository에서 관리할 "영화상영스케줄", "예매내역목록" 컬렉션
    private final ArrayList<MovieInfo> movieSchedule = new ArrayList<>();   // 영화 상영스케줄표 목록
    private final ArrayList<Ticket> ticketList = new ArrayList<>();     // 예매 내역 목록



    // 영황 상영 스케줄표가 저장되어 있는 파일
    private final File movieFile =
            new File("src/main/java/com/movieapp/db/movieDB.dat");

    // 기본 생성자
    public MovieRepository() {
        int movieCounter = 1;   // 영화 등록 번호 자동으로 생성


        if(!movieFile.exists()) {
            // 파일이 존재하지 않으면 생성됨
            ArrayList<MovieInfo> defaultMovies = new ArrayList<>();
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "말할 수 없는 비밀", 8.38, MovieGenre.ROMANCE, MovieGrade.ALL, 103, LocalDate.of(2025, 2, 12), LocalTime.of(10, 0), 60, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "캡틴 아메리카: 브레이브 뉴 월드", 9.44, MovieGenre.ACTION, MovieGrade.TWELVE, 118, LocalDate.of(2025, 2, 12), LocalTime.of(13, 0), 50, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "히트맨 2", 7.57, MovieGenre.ACTION, MovieGrade.FIFTHTEEN, 118, LocalDate.of(2025, 2, 12), LocalTime.of(16, 0), 45, ScreenType.FOURDX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "검은 수녀들", 6.53, MovieGenre.MYSTERY, MovieGrade.FIFTHTEEN, 114, LocalDate.of(2025, 2, 12), LocalTime.of(19, 0), 40, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "브로큰", 5.74, MovieGenre.DRAMA, MovieGrade.FIFTHTEEN, 99, LocalDate.of(2025, 2, 12), LocalTime.of(21, 30), 55, ScreenType.SCREENX));

            defaultMovies.add(new MovieInfo(movieCounter++, Theater.KONKKUK, "하얼빈", 8.09, MovieGenre.HISTORY, MovieGrade.FIFTHTEEN, 114, LocalDate.of(2025, 2, 12), LocalTime.of(10, 0), 45, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.KONKKUK, "쿠로코의 농구 라스트 게임", 9.48, MovieGenre.ANIMATION, MovieGrade.TWELVE, 91, LocalDate.of(2025, 2, 12), LocalTime.of(13, 0), 60, ScreenType.TWOD));

            defaultMovies.add(new MovieInfo(movieCounter++, Theater.APGUJEONG, "말할 수 없는 비밀", 8.38, MovieGenre.ROMANCE, MovieGrade.ALL, 103, LocalDate.of(2025, 2, 12), LocalTime.of(10, 0), 65, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.APGUJEONG, "히트맨 2", 7.57, MovieGenre.ACTION, MovieGrade.FIFTHTEEN, 118, LocalDate.of(2025, 2, 12), LocalTime.of(13, 0), 50, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.APGUJEONG, "검은 수녀들", 6.53, MovieGenre.MYSTERY, MovieGrade.FIFTHTEEN, 114, LocalDate.of(2025, 2, 12), LocalTime.of(16, 0), 45, ScreenType.FOURDX));

            defaultMovies.add(new MovieInfo(movieCounter++, Theater.IPARK, "캡틴 아메리카: 브레이브 뉴 월드", 9.44, MovieGenre.ACTION, MovieGrade.TWELVE, 118, LocalDate.of(2025, 2, 12), LocalTime.of(10, 0), 55, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.IPARK, "브로큰", 5.74, MovieGenre.DRAMA, MovieGrade.FIFTHTEEN, 99, LocalDate.of(2025, 2, 12), LocalTime.of(13, 0), 60, ScreenType.SCREENX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.IPARK, "하얼빈", 8.09, MovieGenre.HISTORY, MovieGrade.FIFTHTEEN, 114, LocalDate.of(2025, 2, 12), LocalTime.of(16, 0), 50, ScreenType.TWOD));
            // 추가적인 10개의 영화 상영 스케줄
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "데드풀 & 울버린", 9.22, MovieGenre.ACTION, MovieGrade.FIFTHTEEN, 125, LocalDate.of(2025, 2, 13), LocalTime.of(11, 0), 55, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.KONKKUK, "오펜하이머", 9.10, MovieGenre.DRAMA, MovieGrade.NINETEEN, 180, LocalDate.of(2025, 2, 14), LocalTime.of(14, 30), 40, ScreenType.SCREENX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.APGUJEONG, "스즈메의 문단속", 8.88, MovieGenre.ANIMATION, MovieGrade.ALL, 122, LocalDate.of(2025, 2, 15), LocalTime.of(10, 0), 60, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.IPARK, "더 배트맨", 8.45, MovieGenre.ACTION, MovieGrade.FIFTHTEEN, 176, LocalDate.of(2025, 2, 16), LocalTime.of(19, 0), 50, ScreenType.FOURDX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "듄: 파트 2", 9.12, MovieGenre.ACTION, MovieGrade.TWELVE, 165, LocalDate.of(2025, 2, 17), LocalTime.of(13, 0), 45, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.KONKKUK, "그랜드 부다페스트 호텔", 8.85, MovieGenre.DRAMA, MovieGrade.FIFTHTEEN, 99, LocalDate.of(2025, 2, 18), LocalTime.of(16, 30), 35, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.APGUJEONG, "탑건: 매버릭", 9.20, MovieGenre.ACTION, MovieGrade.TWELVE, 131, LocalDate.of(2025, 2, 12), LocalTime.of(20, 0), 65, ScreenType.SCREENX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.IPARK, "라라랜드", 8.77, MovieGenre.ROMANCE, MovieGrade.ALL, 128, LocalDate.of(2025, 2, 13), LocalTime.of(21, 30), 50, ScreenType.TWOD));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.GANGNAM, "파묘", 7.89, MovieGenre.THRILLER, MovieGrade.NINETEEN, 111, LocalDate.of(2025, 2, 14), LocalTime.of(17, 0), 30, ScreenType.FOURDX));
            defaultMovies.add(new MovieInfo(movieCounter++, Theater.KONKKUK, "노량: 죽음의 바다", 8.03, MovieGenre.HISTORY, MovieGrade.FIFTHTEEN, 125, LocalDate.of(2025, 2, 15), LocalTime.of(15, 0), 45, ScreenType.TWOD));

            // 파일에 작성
            saveMovies(defaultMovies);
        }

        loadMovies();   // 영화 상영 스케줄표 목록 읽어오기
    }
    // ArrayList<Movie>를 받으면 파일로 덮어씌우는 메소드
    private void saveMovies(ArrayList<MovieInfo> defaultMovies) {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream((movieFile))
                    )
            );
            for(MovieInfo m : defaultMovies){
                oos.writeObject(m);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadMovies() {
        // 파일이 존재할 경우 파일에서 movieSchedule로 가져오기 (db -> load)
        try(ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(movieFile)
                )
        )) {
            while(true){
                movieSchedule.add((MovieInfo) ois.readObject());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
