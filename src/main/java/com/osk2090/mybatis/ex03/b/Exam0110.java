// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.b;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam0110 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/b/mybatis-config.xml")).openSession();

        //selectList(),selectOne(),insert(),update(),delete()
        // selectList(sql id)
        // selectList(sql id,파라미터)
        // 위와 같이 sql 을 실행할 때 오직 한 개의 파라미터만 넘길 수 있다
        // 여러 개의 파라미터를 넘기고 싶다면 객체에 담아서 넘겨라
        //
        // 특정 범위의 번호에 해당하는 게시글을 가져온다

        Map<String, Object> params = new HashMap<>();
        params.put("startNo", 10);
        params.put("endNo", 30);

        List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard1", params);

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


