package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0460 {

    static void m(int i) throws Exception,RuntimeException, SQLException, IOException {
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

    public static void main(String[] args) throws Exception {

        try {
            m(1);
        } catch (RuntimeException | SQLException | IOException exception) {
            //or연산자로 여러 개의 예외를 묶어서 받을 수 있다
            System.out.println(exception.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}