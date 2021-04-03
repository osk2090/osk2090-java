// auto commit - openSession(true)
package com.osk2090.mybatis.ex03.f;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0130 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/f/mybatis-config.xml")).openSession();

        //정렬 방식을 파라미터로 넘기기
        // ${} 문법은 파라미터 값을 sql 문에 그대로 삽입한다
        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3",
                "created_date desc, title asc");

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


