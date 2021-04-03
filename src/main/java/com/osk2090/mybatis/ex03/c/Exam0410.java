// sql 문에 삽입할 파라미터 전달하기 - 한 개의 값(int) 넘기기
package com.osk2090.mybatis.ex03.c;


import com.osk2090.mybatis.vo.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0410 {

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
                "com/osk2090/mybatis/ex03/c/mybatis-config.xml")).openSession();

        Board board = new Board();
        board.setTitle("제목333");
        board.setContent("내용333");

        System.out.printf("insert 실행 전: %s\n", board);

        //insert 문을 실행 한 후에 자동 증가한 pk값 알아내기
        // 자동 증가한 pk값은 sql을 실행할 때 넘겨준 객체에 담겨있을 것이다
        // 단 sql 매퍼 파일에서 insert 문을 정의할 때 설정해 줘야 한다
        // useGeneratedKeys: 자동 증가한 pk 컬럼 값을 사용할 것인지 지정한다
        // keyColumn: 자동 증가 pk 컬럼의 이름을 지정한다
        // keyProperty: 자동 증가 pk 컬럼의 값을 저장할 자바 객체의 프로퍼티를 지정한다

        //게시글을 입력한다
        int count = sqlSession.insert("BoardMapper.insert3", board);

        System.out.printf("%d 개의 데이터를 입력 했음!\n", count);

        sqlSession.commit();

        sqlSession.close();
        System.out.printf("insert 실행 후: %s\n", board);

        System.out.println("실행 완료!");
    }

}


