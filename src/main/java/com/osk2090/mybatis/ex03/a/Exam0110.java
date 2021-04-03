// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.a;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/a/mybatis-config.xml")).openSession();

        //sql을 실행할 때 파라미터 값을 전달하려면
        // 두 번째 파라미터로 전달해야 한다
        // 여러 개의 값을 전달해야 한다면
        // 도메인 객체나 Map객레에 담아 전달해라
        //
        // 예) 특정 번호의 게시글을 가져온다

        List<Board> boards = sqlSession.selectList ("BoardMapper.selectBoard1", 37);

        for (Board b : boards) {
            System.out.printf("%d,%s,%s,%s,%d\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getContent(),
                    b.getRegisteredDate(),
                    b.getViewCount());
        }

        sqlSession.close();
        System.out.println("실행 완료!");
    }

}


