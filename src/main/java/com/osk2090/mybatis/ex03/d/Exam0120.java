// auto commit - openSession(true)
package com.osk2090.mybatis.ex03.d;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0120 {

    //openSession(auto commit 여부)
    //true: 데이터 변경 후 즉시 커밋한다
    //false: 데이터 변경 후 commit()을 호출할 때까지 실제 테이블에 변경 사항을 반영하지 않는다

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/d/mybatis-config.xml")).openSession(true);

        Board board = new Board();
        board.setTitle("제목xxx");
        board.setContent("내용xxx");

        int count = sqlSession.insert("BoardMapper.insert", board);
        System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

        //commit()을 호출하지 않아도 즉시 테이블에 변경 사항을 반영한다

        sqlSession.close();

        System.out.println("실행 완료!");
    }

}


