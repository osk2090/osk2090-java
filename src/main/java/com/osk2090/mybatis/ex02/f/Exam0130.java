// SqlSession 사용법 - 결과가 여러 개일때 selectOne() 사용하면?
package com.osk2090.mybatis.ex02.f;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0130 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex02/f/mybatis-config.xml")).openSession();

        //Map 객체로 받으려면 sql 매퍼에서 다음과 같이 resultType을 설정해야 한다
        // <select id="selectBoard3" resultType="aap" parameterType="int">
        //        select board_id,
        //               title,
        //               contents,
        //               created_date,
        //               view_count
        //        from x_board
        //        where board_id = #{no};
        //    </select>
        //
        // 컬럼 이름이나 별명으로 컬럼 값을 저장하기 때문에
        // map 객체에 컬럼 값을 꺼낼 때 컬럼 이름이나 별명을 사용해야 한다

        Board b = sqlSession.selectOne("BoardMapper.selectBoard3");

        if (b == null) {
            System.out.println("해당 번호의 게시글이 없습니다.");
            return;
        }
        
        System.out.printf("%d,%s,%s,%s,%d\n",
                b.getNo(),
                b.getTitle(),
                b.getContent(),
                b.getRegisteredDate(),
                b.getViewCount());

        sqlSession.close();
    }

}


