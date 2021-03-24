package com.osk2090.jdbc.ex2;

import java.sql.*;
import java.util.Scanner;

public class Exam0411 {
    public static void main(String[] args) throws Exception {
        String title = null;
        String contents = null;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("제목? ");
            title = scanner.nextLine();

            System.out.println("내용? ");
            contents = scanner.next();
        }

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb?user=study&password=1111"
        );
             PreparedStatement stmt = con.prepareStatement(
                     "insert into x_board(title,contents) values (?,?)",
                     Statement.RETURN_GENERATED_KEYS
             )) {

            stmt.setString(1, title);
            stmt.setString(2, contents);
            int count = stmt.executeUpdate();
            System.out.printf("%d 개 입력 성공!\n", count);

            //insert 수행 후 자동 생성된 PK 값은 따로 요구해야 한다
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                //insert를 한 개만 했기 때문에 PK도 한 개만 생성되었다
                //따라서 ResultSet에 대해 여러 번 반복을 할 필요가 없다
                rs.next();

                //자동 생성된 PK값을 꺼낼 때는 따로 컬럼 이름이 없기 때문에 컬럼 인덱스로 꺼낸다

                int no = rs.getInt(1);
                System.out.printf("입력된 게시글 번호: %d\n", no);
            }
        }
    }
}