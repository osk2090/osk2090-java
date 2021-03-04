package com.osk2090.Exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0120 {
    static Board read() throws RuntimeException {
        try (Scanner scan = new Scanner(System.in)) {
            Board board = new Board();

            System.out.println("번호>");
            board.setNo(Integer.parseInt(scan.nextLine()));

            System.out.println("제목>");
            board.setTitle(scan.nextLine());

            System.out.println("내용>");
            board.setContent(scan.nextLine());

            System.out.println("등록일>");
            board.setCreatedDate(Date.valueOf(scan.nextLine()));

            return board;
        }
    }

    public static void main(String[] args) {
        try {
            Board board = read();
            System.out.println("---------------------");
            System.out.printf("번호: %d\n", board.getNo());
            System.out.printf("제목: %s\n", board.getTitle());
            System.out.printf("내용: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
        } catch (RuntimeException e) {
            System.out.println(e.getClass());
            System.out.println("게시물 입력중에 오류 발생");
        }
    }
}