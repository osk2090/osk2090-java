package com.osk2090.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Exam0210 {
    public static void main(String[] args) throws Exception {

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb",
                    "study",
                    "1111");

            System.out.println("DBMS와 연결됨!");

            System.out.println(con.getClass().getName());

        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("DBMS와 연결 해제됨!");
        }
    }
}