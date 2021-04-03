// auto commit - openSession(true)
package com.osk2090.mybatis.ex03.e;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.HashMap;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/e/mybatis-config.xml")).openSession(true);

        //게시글 입력
        Board board = new Board();
        board.setTitle("제목1");
        board.setContent("내용1");

        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

        HashMap<String, Object> fileInfo = new HashMap<>();

        //첫번째 첨부파일 입력
        fileInfo.put("filePath", "aaa.gif");
        fileInfo.put("boardNo", board.getNo());
        count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
        System.out.printf("%d 개의 첨부파일을 입력 했음!\n", count);

        //두번째 첨부파일 입력
        fileInfo.put("filePath", "bbb.gif");
        fileInfo.put("boardNo", board.getNo());
        count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
        System.out.printf("%d 개의 첨부파일을 입력 했음!\n", count);


        //세번째 첨부파일 입력
        fileInfo.put("filePath", "12345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456789012345678901234567890"
                + ".gif");
        fileInfo.put("boardNo", board.getNo());
        count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
        System.out.printf("%d 개의 첨부파일을 입력 했음!\n", count);


        //auto commit일 때
        // 데이터 변경 sql 문을 싱행하면 즉시 테이블에 적용한다
        // 따라서 세 번째 첨부파일을 입력하다가 오류가 발생하더라도
        // 이전에 수행했던 데이터 변경 작업은 완료된 상태이다

        sqlSession.close();

        System.out.println("실행 완료!");
    }

}


