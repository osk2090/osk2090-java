package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class test {
    static void m(int i) throws Exception {//해당 메서드에서 예외가 발생하면 그 예외를 던진다
        if (i == 1) {
            throw new Exception("e");
        } else if (i == 2) {
            throw new IOException("i");
        } else if (i == 3) {
            throw new RuntimeException("r");
        } else {
            throw new SQLException("s");
        }
    }

    public static void main(String[] args) /*throws Exception 생략됨*/{
        try {//try과 catch문을 사용하면 throws Exception을 생략할 수 있다
            m(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}