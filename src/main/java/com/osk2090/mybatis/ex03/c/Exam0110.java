// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.c;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.HashMap;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/c/mybatis-config.xml")).openSession();

        HashMap<String, Object> parmas = new HashMap<>();
        parmas.put("title", "제목2");
        parmas.put("content", "내용2");

        int count = sqlSession.insert("BoardMapper.insert2", parmas);
        System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

        sqlSession.commit();

        sqlSession.close();

        System.out.println("실행 완료!");
    }

}


