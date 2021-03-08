package com.osk2090.net.ex07;

import java.net.URL;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        //포트번호 명시
        URL url = new URL("https://docs.google.com/forms/d/e/1FAIpQLScN6ZjAYtGGV4Tst0NSLpxClZZHNJTCXPTd3WH0Syf6q858rQ/viewform?vc=0&c=0&w=1&flr=0");

        //URL분석
        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());

        System.out.printf("포트번호: %d\n", url.getPort());
        //웹브라우저에서는 포트번호를 생략하면80,443번으로 간주된다
        //다만 getPort()의 리턴 값은 -1이다

        System.out.printf("자원경로: %s\n", url.getPath());
        System.out.printf("QueryString: %s\n", url.getQuery());
    }
}