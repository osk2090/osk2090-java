// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.c;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0210 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/c/mybatis-config.xml")).openSession();

        Board board = new Board();
        board.setNo(41);
        board.setTitle("제목을 변경한다");
        board.setContent("내용을 변경한다");

        //update 문을 실행 할 때는 update()메서드를 호출한다
        // 리턴 값은 executeUpdate()의 실행 결과이다
        //즉 update 된 데이터의 개수이다

        // 게시글을 입력한다
        int count = sqlSession.update("BoardMapper.update", board);
        System.out.printf("%d 개의 데이터를 변경 했음!\n", count);

        sqlSession.commit();

        sqlSession.close();

        System.out.println("실행 완료!");
    }

}


