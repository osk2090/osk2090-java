package com.osk2090.Exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0440 {

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
            m(3);
            System.out.println("실행 성공!");
        } catch (Exception e) {//수퍼클래스가 맨 위에 있으면 나머지 서브클래스들이 필요가 없으므로 해당 수퍼 클래스를 먼저 받지 말라
            //맨 마지막으로 받는다
//        } catch (IOException e) {
//        } catch (SQLException e) {
//        } catch (RuntimeException e) {
        }
    }
}