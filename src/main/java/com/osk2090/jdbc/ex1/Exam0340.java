package com.osk2090.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam0340 {
    public static void main(String[] args) throws Exception {
        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111"
                );
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc")
        ) {
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