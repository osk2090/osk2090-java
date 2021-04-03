// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.a;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0140 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/a/mybatis-config.xml")).openSession();

        //CDATA 섹션
        //xml 파서에게 해당 블록의 내용물이 단순 텍스트임을 알려주는 명령어이다
        //문법
        // <![CDATA[ 내용물 ]]>
        // 내용물 안에서 xml 파서가 혼동을 일으킬 문자가 많을 때 사용하기 적합하다
        //
        // 특정 번호 미만의 게시글을 가져온다

        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard4", 10);

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


