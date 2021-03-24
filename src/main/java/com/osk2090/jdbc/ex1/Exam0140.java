package com.osk2090.jdbc.ex1;

import java.sql.Driver;
import java.sql.DriverManager;

public class Exam0140 {
    public static void main(String[] args) {
        /*
        JDBC 드라비어 등록 방법4:Driver 구현체 자동 로딩
        DriverManager를 사용할 때
        DriverManager는 다음 절차에 따라 Driver 구현체를 찾아서 자동으로 로딩한다

        1.jdbc.drivers 시스템 프로퍼티에 지정된 구현체를 찾아 로딩한다
        jdbc.drivers=foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver
        이때 각 Driver 구현체는 'system class loader'를 통해 로딩된다
        시스템 프로퍼티?JVM에 설정된 "key=value"이다
        시스템 프로퍼티를 꺼내는 방법
         */
        System.out.printf("java.home=%s\n", System.getProperty("java.hone"));
        System.out.printf("user.hone=%s\n", System.getProperty("user.home"));
        System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));

        /*
        시스템 프로퍼티 설정 방법
        예1)JVM을 실행할 때 JVM 옵션을 지정하는 방법
        java =Djdbc.drivers=클래스명:클래스명:클래스명 Exam0140

        예2)프로그램 코드에서 설정하는 방법
        System.getProperty("jdbc.drivers","com.eomcs.jdbc.ex1.MyDriver");
         */
        System.setProperty("jdbc.drivers", "com.eomcs.jdbc.ex1.MyDriver:org.mariadb.jdbc.Driver");
        System.setProperty("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));

        try {
            /*
            Driver 구현체를 명시적으로 로딩하지 않는다
            그래도 service-provider loading 절차에 따라
            mariadb의 Driver 구현체가 로딩되고 객체가 생성되어 등록될 것이다
             */
            Driver driver = DriverManager.getDriver("jdbc:mariadb:");
            System.out.println(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}