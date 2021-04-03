package com.osk2090.jdbc.ex03;

import java.util.Scanner;

public class Exam0130 {
    public static void main(String[] args) throws Exception {
        String no = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("번호? ");
            no = scanner.nextLine();
        }

        try {
            BoardDao boardDao = new BoardDao();
            Board board = boardDao.findBy(no);

            if (board != null) {
                System.out.printf("제목: %s\n", board.getTitle());
                System.out.printf("내용: %s\n", board.getContent());
                System.out.printf("등록일: %s\n", board.getRegisteredDate());
                System.out.printf("조회수: %d\n", board.getViewCount());
            } else {
                System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}