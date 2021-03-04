package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0471 {

    static void m(int i) throws Exception,RuntimeException, SQLException, IOException {
        if (i == 0) {
            throw new Exception("0");
        } else if (i == 1) {
            throw new RuntimeException("1");
        } else if (i == 2) {
            throw new SQLException("2");
        } else if (i == 3) {
            throw new IOException("3");
        } else if (i < 0) {
            throw new Error("E");
        }
    }

    public static void main(String[] args) throws Exception {

        try {
            m(-1);
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            System.out.println("애플리케이션 예외 발생");
            /*
            catch문을 작성할 때
            이처럼 무심코 Throwable 변수로 선언하면
            시스템 오류인 Error까지 받기 때문에
            jvm에서 발생된 오류에 대해서도 예외 처리를 하는 문제가 발생한다
            시스템 오류는 애플리케이션에서 처리할 수 없다
            따라서 실무에서는 예외를 받을 때
            Throwable 변수를 사용하지 않는다
             */
        }
    }
}