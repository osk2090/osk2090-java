package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0420 {

    static void m(int i)throws Exception,RuntimeException, SQLException, IOException {
        if (i == 0) {
            throw new Exception("0");
        } else if (i == 1) {
            throw new RuntimeException("1");
        } else if (i == 2) {
            throw new SQLException("2");
        } else {
            throw new IOException("...");
        }
    }

    static void mm() throws Exception, RuntimeException, SQLException, IOException {//해당 메서드 호출자에게 예외를 떠넘길려면 해당 코드를 삽입해야 한다
        m(2);
    }

    public static void main(String[] args) {
        try {
            mm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}