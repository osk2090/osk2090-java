// Mybatis 설정 파일 - 도메인 클래스의 별명을 걸정하는 또 다른 방법
package com.osk2090.mybatis.ex02.c;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex02/c/mybatis-config.xml")).openSession();


        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

        /*
        컬럼명과 자바 객체의 프로퍼티명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올수 있다
         */
        for (Board b : boards) {
            System.out.printf("%d,%s,%s,%s,%d\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getContent(),
                    b.getRegisteredDate(),
                    b.getViewCount());

            /*
            컬럼의 값을 자바 객케에 담으려면 컬럼과 같은 이름의 프로퍼티가 있어야 한다
            없다면 위와 같이 프로퍼티 명을 컬럼의 별명으로 지정하라
             */
        }
        sqlSession.close();
    }

}


