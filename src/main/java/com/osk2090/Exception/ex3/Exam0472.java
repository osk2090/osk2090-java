package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0472 {

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
        } catch (Exception e) {
            System.out.println("애플리케이션 예외 발생");
            /*
            이렇게 Exception 변수를 사용하면
            애플리케이션 예외를 처리하고
            시스템 예외는 main() 호출자에게 위임하게 된다
            즉 jvm에게 전달한다
            이렇게 Exception 계열의 애플리케이션 예외만 처리하라
             */
        }
    }
}