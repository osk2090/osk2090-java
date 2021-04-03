// Mybatis 설정 파일 - 도메인 클래스의 별명을 걸정하는 또 다른 방법
package com.osk2090.mybatis.ex01.e;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0110 {

    public static void main(String[] args) throws Exception {


        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex01/e/mybatis-config.xml")).openSession();

        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

        System.out.println(boards.size());

        sqlSession.close();
    }

}


