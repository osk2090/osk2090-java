package com.osk2090.jdbc.ex1;

import java.io.FileReader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class Exam0131 {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileReader("./jdbc-driver.properties"));//해당 파일로 접근한다
            System.out.println(props.getProperty("jdbc.driverClassName"));
            System.out.println(props.getProperty("jdbc.url"));

            //파일 내용물을 읽어서 Driver 인스턴스가 생성되어 DriverManager에게 등록
            Class.forName(props.getProperty("jdbc.driverClassName"));
            //DriverManager에 자동 등록된 것을 확인
            Driver driver = DriverManager.getDriver(props.getProperty("jdbc.url"));
            System.out.println(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}