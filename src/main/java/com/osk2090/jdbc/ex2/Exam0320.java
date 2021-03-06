package com.osk2090.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam0320 {
    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb?user=study&password=1111"
        ); PreparedStatement stmt = con.prepareStatement(
                "select * from x_board order by board_id asc "
        );
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("번호 제목, 등록일, 조회수");
            while (rs.next()) {
                System.out.printf("%d, %s, %s, %s, %d\n",
                        rs.getInt("board_id"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("created_date"),
                        rs.getInt("view_count"));

            }
        }
    }
}