package com.osk2090.jdbc.ex1;

import java.sql.Driver;
import java.sql.DriverManager;

//JDBC 드라비어 준비- 드라이버 다운로드 및 로딩
public class Exam0110 {
    /*
    DBMS에 연결하기
    MariaDB에 연결을 대행하는 클래스를 사용한다
    이 클래스는 JDBC API 규칙에 따라 작성되었다
    이 클래스는 JDBC Driver 파일(*.jar)에 들어 있다
    이 클래스를 사용하려면 먼저 이 JDBC Driver 파일을 다운로드 받아
    프로젝트의 CLASSPATH에 등록해야 한다
    절차
    mvnrepository.com 또는 search.maven.org 에서 mariadb jdbc driver를 검색한다
    라이브러리 정보를 build.gradle 파일에 설정한다
    gradle을 이용하여 eclipse 설정 파일을 갱신한다
    gradle eclipse
    다룬로드 받지 않은 라이브러르가 있다면 자동으로 서버에서 받을 것이다
    라이브러리 정보가 변경되었다면 해당 라이브러리를 서버에서 받을 것이다
    이클립스 프로젝트를 리프레시한다
    프로젝트에 mariadb jdbc driver 라이브러리사 추가되었는지 확인한다
     */
    public static void main(String[] args) {
        /*
        JDBC 드라이버 등록
        java.sql.Driver 규칙에 따라 정의된 클래스를 로딩한다
        Driver 구현체는 JDBC에 대한 정보를 제공한다
        또한 DBMS에 연결 작업을 수행한다
        Driver 구현체는 DriverManager 가 관리한다
        따라서 접속할 DBMS의 Driver 구현체를 생성하여 DriverManager에게 등록해야 한다

        DriverManager
        java.sql.Driver 구현 객체를 관리하는 일을 한다
        DBMS 연결 요청이 들어오면 해당 DBMS의 Driver 구현체를 찾아 작업을 위임한다

        JDBC 드라이버 등록 방법1:직접 Driver 구현 객체를 생성하고 직접 등록하기
        java.sql.Driver 구현체를 생성하여 JDBC 드라이버 관리자에 등록한다
        MariaDB의 JDBC 드라이버에는 org.mariadb.jdbc,Driver 클래스가 이 구현체이다

         */
        try {
            //1.Driver 구현체의 인스턴스를 생성한다
            Driver mariadbDriver = new org.mariadb.jdbc.Driver();
            Driver oracleDriver = new org.mariadb.jdbc.Driver();
            Driver mssqlDriver = new org.mariadb.jdbc.Driver();

            //2.Driver 인스턴스를 드라이버 관리자에 등록한다
            DriverManager.registerDriver(mariadbDriver);
            DriverManager.registerDriver(oracleDriver);
            DriverManager.registerDriver(mssqlDriver);

            System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

            /*
            DriverManager에 등록된 Driver 인스턴스를 확인해보자
             => DriverManager.getDriver(jdbcUrl);
             => jdbcUrl
            jdbc:[DBMS]://서버주소:포트번호/데이터베이스명
             */
            Driver driver = DriverManager.getDriver("jdbc:mariadb://");
            System.out.println(driver);

            Driver driver1 = DriverManager.getDriver("jdbc:oracle:thin://");
            System.out.println(driver1);

            Driver driver2 = DriverManager.getDriver("jdbc:sqlserver://");
            System.out.println(driver2);

            //다음과 같이 파라미터로 지정한 JDBC 드라이버를 못찾으면 예외가 발생한다
//            Driver driver3 = DriverManager.getDriver("jdbc:db2://");
//            System.out.println(driver3);에러 발생

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}