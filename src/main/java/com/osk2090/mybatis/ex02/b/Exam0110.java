// Mybatis 설정 파일 - 도메인 클래스의 별명을 걸정하는 또 다른 방법
package com.osk2090.mybatis.ex02.b;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex02/b/mybatis-config.xml")).openSession();

        /*
        selectList()
        select 문의 결과가 여러 개일 때 사용한다
        결과가 없으면 size가 0인 List객체를 리턴한다
         */

        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

        for (Board b : boards) {
            System.out.printf("%d,%s,%s,%s,%d\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getContent(),
                    b.getRegisteredDate(),
                    b.getViewCount());

            /*
            실행결과가 기대와 같지 않은 이유?
            mybatis에서 결과 값을 Board객체에 담을 때 일부 컬럼의 값을 담지 못했기 때문이다

            왜 일부 컬럼의 값을 Board에 담지 못했는가
            mybatis에서 결과의 컬럼 값을 자바 객체에 담을 때
            컬럼 이름과 같은 이름을 가진 프로퍼티(셋터 메서드)를 찾는다
            컬럼 이름과 일치하는 프로퍼티가 없다면
            셋터 메서드를 호출할 수 없기 때문에
            해당 컬럼의 값이 자바 객체에 저장되지 못한다
             */
        }
        sqlSession.close();
    }

}


