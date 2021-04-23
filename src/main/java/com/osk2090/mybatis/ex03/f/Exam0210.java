// auto commit - openSession(true)
package com.osk2090.mybatis.ex03.f;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Scanner;

public class Exam0210 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 게시글의 제목? ");
        String input = scanner.nextLine();

        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/f/mybatis-config.xml")).openSession(true);

        //#{} 문법은 sql에 값을 삽입할 때 사용한다
        // 사용자가 입력한 값에 sql 코드를 포함하더라도
        // 그냥 값으로 취급하기 때문에 실행에는 영향을 끼치지 않는다
        // 즉 sql 삽입 공격이 불가능하다
        // 삭제할 게시글의 제목에 sql에 영향을 끼치는 코드를 삽입하여 실행해 보라
        // 어떤 영향도 주지 못할 것이다
        int count = sqlSession.delete("BoardMapper.delete1", input);
        System.out.println(count);

        sqlSession.close();
        scanner.close();
        System.out.println("실행 완료!");
    }

}


