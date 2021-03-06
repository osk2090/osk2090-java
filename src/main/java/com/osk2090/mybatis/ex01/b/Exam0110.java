package com.osk2090.mybatis.ex01.b;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex01/b/mybatis-config.xml")).openSession();

        System.out.println("mybatis 사용 준비 완료!");

        sqlSession.close();
    }
}