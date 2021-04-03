// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.a;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0120 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/a/mybatis-config.xml")).openSession();

        //예: 특정 제목의 게시글을 가져온다
//인파라미터로 들어가는 단어중에서 찾아서 출렧해준다
        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard2", "제목입니다");

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


