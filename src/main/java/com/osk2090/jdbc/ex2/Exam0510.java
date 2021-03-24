package com.osk2090.jdbc.ex2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0510 {
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
             PreparedStatement boardStmt = con.prepareStatement(
                     "insert into x_board(title,contents) values (?,?)",
                     Statement.RETURN_GENERATED_KEYS
             );
             PreparedStatement fileStmt = con.prepareStatement(
                     "insert into x_board_file(file_path,board_id) values (?,?)"
             )) {
            boardStmt.setString(1, title);
            boardStmt.setString(2, contents);
            int count = boardStmt.executeUpdate();
            System.out.printf("%d 개 게시글 입력 성공!\n", count);

            ResultSet keyRS = boardStmt.getGeneratedKeys();
            keyRS.next();
            int boardId = keyRS.getInt(1);

            int fileCount = 0;
            for (String filename : files) {
                fileStmt.setString(1, filename);
                fileStmt.setInt(2, boardId);

                fileStmt.executeUpdate();
                fileCount++;
            }
            System.out.printf("%d 개 첨부파일 입력 성공!\n", fileCount);
        }
    }
}