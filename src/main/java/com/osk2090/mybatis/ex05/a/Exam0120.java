// 조인 데이터 가져오기 - 각 테이블의 데이터를 별도로 가져오기
package com.osk2090.mybatis.ex05.a;

import com.osk2090.mybatis.vo.AttachFile;
import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Scanner;

public class Exam0120 {

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("게시글 번호? ");
        int no = Integer.parseInt(keyboard.nextLine());
        keyboard.close();

        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex05/a/mybatis-config.xml")).openSession();

        // 게시글 데이터를 가져올 때 첨부 파일 데이터도 포함해서 가져올 수 있다.
        // => 테이블 조인 기법을 사용한다.
        // => 도메인 객체의 포함 관계를 활용한다.
        //
        Board b = sqlSession.selectOne("BoardMapper.selectBoard2", no);

        System.out.println("[게시글 상세보기]");
        System.out.printf("번호: %d\n", b.getNo());
        System.out.printf("제목: %s\n", b.getTitle());
        System.out.printf("내용: %s\n", b.getContent());
        System.out.printf("등록일: %s\n", b.getRegisteredDate());
        System.out.printf("조회수: %d\n", b.getViewCount());

        System.out.println("첨부파일:");

        for (AttachFile f : b.getAttachFiles()) {
            System.out.printf("  %d - %s\n", f.getFileNo(), f.getFilePath());
        }

        sqlSession.close();
    }

}
