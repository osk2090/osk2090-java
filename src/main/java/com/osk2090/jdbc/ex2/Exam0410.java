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
             PreparedStatement boardStmt = con.prepareStatement(
                     "insert into x_board(title,contents) values(?,?)"
             );

             PreparedStatement fileStmt = con.prepareStatement(
                     "insert into x_board_file(file_path,board_id) values (?,?)"
             )) {
            boardStmt.setString(1, title);
            boardStmt.setString(2, contents);
            int count = boardStmt.executeUpdate();
            System.out.printf("%d 개 게시글 입력 성공!", count);

            int fileCount = 0;
            for (String filename : files) {
                fileStmt.setString(1, filename);
                fileStmt.setInt(2, 0);
                /*
                첨부파일 데이블에 데이터를 입력하려면
                게시글 테이블의 게시글 번호를 알아야 한다
                문제는 바로 위에서 입력한 게시글의 PK가 자동 생성되는 컬럼이기 때문에
                입력한 후 그 PK값이 뭔지 알 수가 없다는 것이다
                그래서 첨부파일 테이블에 데이터를 입력할 수 없다

                해결책
                데이터를 입력할 때 자동 생성된 PK 값을 알 수 있다면
                이 문제를 해결할 수 있다
                다음으로 확인
                 */

                fileStmt.executeUpdate();
                fileCount++;
            }
            System.out.printf("%d 개 첨부파일 입력 성공!", fileCount);
        }
    }
}