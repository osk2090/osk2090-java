package com.osk2090.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0130 {
    public static void main(String[] args) throws Exception {
        String no = null;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("번호 ?");
            no = scanner.nextLine();
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from x_board where board_id = " + no
             )) {
            if (rs.next()) {
                System.out.printf("제목: %s\n", rs.getString("title"));
                System.out.printf("내용: %s\n", rs.getString("contents"));
                System.out.printf("등록일: %s\n", rs.getDate("created_date"));
                System.out.printf("조회수: %s\n", rs.getInt("view_count"));
            }
        }
    }
}