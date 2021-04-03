// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.c;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0310 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/c/mybatis-config.xml")).openSession();

        //delete 문을 실행할 때는 delete() 메서드를 호출한다
        //리턴 값은 executeUpdate()의 실행 결과이다
        //즉 delete 된 데이터의 개수이다

        // 게시글을 입력한다
        int count = sqlSession.delete("BoardMapper.delete", 41);

        System.out.printf("%d 개의 데이터를 삭제 했음!\n", count);

        sqlSession.commit();

        sqlSession.close();

        System.out.println("실행 완료!");
    }

}


