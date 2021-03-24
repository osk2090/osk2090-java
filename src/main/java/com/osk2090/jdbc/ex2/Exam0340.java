package com.osk2090.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0340 {
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

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb?user=study&password=1111"
        );
             PreparedStatement stmt = con.prepareStatement(
                     "update x_board set title = ?,contents = ? where board_id = ?"
             )) {
            stmt.setString(1, title);
            stmt.setString(2, contents);
            stmt.setString(3, no);
            System.out.println(stmt.executeUpdate());

            int count = stmt.executeUpdate();
            if (count == 0) {
                System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
            } else {
                System.out.println("변경하였습니다.");
            }
        }
    }
}