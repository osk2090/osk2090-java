package com.osk2090.net.ex07;

import java.net.URL;

public class Exam01 {
    /*
    웹 상에서 자원의 위치를 표현하는 방법
    [프로토콜]://서버주소:포트번호/자원의경로?파라미터명=값&파라미터명=값
    프로토콜:http(80).https(443),ftp(21/20) 등
    서버주소:IP주소,도메인명
    자원의 경로: /index.html, /board/list.jsp 등
    서버에 보내는 파라미터(Query String): 파라미터명=값&파라미터명=값

     */
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://cafe.naver.com/sssw/13281555");

        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());
        System.out.printf("포트번호: %d\n", url.getPort()); // 지정하지 않으면 -1 리턴. 실제 접속할 때는 기본 포트번호 사용.
        System.out.printf("자원경로: %s\n", url.getPath());
        System.out.printf("서버에 보내는 파라미터: %s\n", url.getQuery());
    }

}