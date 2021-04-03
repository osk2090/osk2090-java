// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.a;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Exam0130 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/a/mybatis-config.xml")).openSession();

        //xml 파서가 혼동을 일으킬수 있는(xml 파싱 오류 발생) 문자를 사용할 때
        // 그 문자 대신 xml Entity를 사용하라
        // " => &quot;
        //    //   ' => &apos;
        //    //   & => &amp;
        //    //   < => &lt;
        //    //   > => &gt;

        //특정 번호 미만의 게시글을 가져온다--------10미만의 게시글 출력
        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3", 10);

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


