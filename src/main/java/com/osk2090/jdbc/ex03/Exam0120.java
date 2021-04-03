package com.osk2090.jdbc.ex03;

import java.util.List;

public class Exam0120 {
    public static void main(String[] args) throws Exception {
        try {
            BoardDao boardDao = new BoardDao();
            List<Board> list = boardDao.findAll();
            System.out.println("번호, 제목, 등록일, 조회수");
            for (Board b : list) {
                System.out.printf("%d, %s, %s, %s, %d\n",
                        b.getNo(),
                        b.getTitle(),
                        b.getContent(),
                        b.getRegisteredDate(),
                        b.getViewCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}