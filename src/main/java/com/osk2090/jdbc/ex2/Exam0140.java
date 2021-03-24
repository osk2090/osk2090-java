package com.osk2090.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0140 {
    public static void main(String[] args) throws Exception {
        String no = null;
        String title = null;
        String contents = null;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("번호? ");
            no = scanner.nextLine();

            System.out.println("제목? ");
            title = scanner.nextLine();

            System.out.println("내용? ");
            contents = scanner.nextLine();

        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
             Statement stmt = con.createStatement();
        ) {
            String sql = String.format("update X_board set title='%s',contents='%s' where board_id=%s",
                    title, contents, no);

            int count = stmt.executeUpdate(sql);

            if (count == 0) {
                System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
            } else {
                System.out.println("변경하였습니다.");
            }
        }
    }
}