package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0520 {

    static void m(int i) throws Exception,RuntimeException, SQLException, IOException {
        if (i == 0) {
            throw new Exception("0");
        } else if (i == 1) {
            throw new RuntimeException("1");
        } else if (i == 2) {
            throw new SQLException("2");
        } else if (i == 3) {
            throw new IOException("3");
        }
    }

    public static void main(String[] args) throws Exception {

        try {
            m(1);
        }finally {
            System.out.println("마무리 작업 실행");
        }
    }
}