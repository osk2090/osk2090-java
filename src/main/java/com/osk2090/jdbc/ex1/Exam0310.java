package com.osk2090.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam0310 {
    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb?" +
                "user=study&password=1111");

             Statement stmt = con.createStatement();) {

            System.out.println(stmt.getClass().getName());

            int count = stmt.executeUpdate(
                    "insert into x_board(title,contents) values('제목10','내용')");
            System.out.printf("%d 개 입력 성공!", count);
        }
    }
}