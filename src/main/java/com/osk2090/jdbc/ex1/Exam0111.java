package com.osk2090.jdbc.ex1;

import java.sql.Driver;
import java.sql.DriverManager;

//JDBC 드라이버 준비-드라이버 다룬로드 및 로딩
public class Exam0111 {
    public static void main(String[] args) {
        try {
            Driver mariadbDriver = new org.mariadb.jdbc.Driver();
            DriverManager.registerDriver(mariadbDriver);
            System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

            //등록되지 않은 드라이버를 찾을 경우 예외 발생!
//            Driver driver = DriverManager.getDriver("jdbc:oracle://");에러 발생
            Driver driver = DriverManager.getDriver("jdbc:mariadb://");
            System.out.println(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}