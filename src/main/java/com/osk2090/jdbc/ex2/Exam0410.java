package com.osk2090.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0410 {
    public static void main(String[] args) throws Exception {
        String title = null;
        String contents = null;
        ArrayList<String> files = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("제목? ");
            title = scanner.nextLine();

            System.out.println("내용? ");
            contents = scanner.nextLine();

            while (true) {
                System.out.println("첨부파일:(완료는 그냥 엔터!) ");
                String filename = scanner.nextLine();
                if (filename.length() == 0) {
                    break;
                }
                files.add(filename);
            }
        }

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb?user=study&password=1111"
        );
             PreparedStatement boardStmt = con.prepareStatement()) {

        }
    }
}