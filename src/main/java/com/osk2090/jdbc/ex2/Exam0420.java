package com.osk2090.jdbc.ex2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0420 {
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

            ResultSet keyRS = boardStmt.getGeneratedKeys();//x_board 테이블의 board_id를 가져온다
            keyRS.next();//board_id가 있다면 true
            int boardId = keyRS.getInt(1);//그 레코드에서 인덱스 1에 있는 컬럼 값을 꺼낸다

            int fileCount = 0;
            for (String filename : files) {
                fileStmt.setString(1, filename);
                fileStmt.setInt(2, boardId);//위에서 가져온 컬럼값을 board_id로 입력해준다

                fileStmt.executeUpdate();//???용도가 무엇인가
                fileCount++;
            }
            System.out.printf("%d 개 첨부파일 입력 성공!\n", fileCount);
        }
    }
}