package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0410 {

    static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
        if (i == 0) {
            throw new Exception("Exception");
        } else if (i == 1) {
            throw new RuntimeException("RuntimeException");
        } else if (i == 2) {
            throw new SQLException("SQLException");
        } else {
            throw new IOException("IOException");
        }
    }

    public static void main(String[] args) throws Exception {
        m(1);//해당 메서드를 호출하려면 throws Exception를 main메서드에 선언해야 한다

        try {//위와 같이 선언을 안하려면 try-catch문을 사용하여 메서드에서 던진 예외를 catch가 잡아와서
             //에러메시지를 개발자에게 알려준다.
            m(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}