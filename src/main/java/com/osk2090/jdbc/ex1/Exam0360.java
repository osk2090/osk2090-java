package com.osk2090.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam0360 {
    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
             Statement stmt = con.createStatement()) {
            int count = stmt.executeUpdate(
                    "delete from x_board where board_id = 1");
            System.out.printf("%d 개 삭제 성공!", count);
        }
    }
}