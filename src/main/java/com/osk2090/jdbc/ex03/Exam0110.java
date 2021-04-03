package com.osk2090.jdbc.ex03;

import java.util.Scanner;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("제목? ");
            board.setTitle(scanner.nextLine());

            System.out.println("내용? ");
            board.setContent(scanner.nextLine());

            System.out.println("입력하시겠습니까?(Y/n) ");
            String input = scanner.nextLine();

            if (!input.equalsIgnoreCase("y") && input.length() == 0) {
                System.out.println("등록을 취소하였습니다.");
                return;
            }
        }

        try {
            BoardDao boardDao = new BoardDao();
            int count = boardDao.insert(board);
            System.out.printf("%d 개 입력 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}