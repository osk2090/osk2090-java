package com.osk2090.net.ex01;

import java.net.Socket;

public class Sender {
    public static void main(String[] args) throws Exception {
        System.out.println("클라이언트 실행!");

        //1.다른 컴퓨터와 네트워크로 연결한다
        //서버와 연결되면 Socket 객체가 생성된다
        //서버와 연결될 때까지 리턴하지 않는다
        // 서버에 연결할 수 없으면 예외가 발생한다
        //localhost == 127.0.0.1:현재  컴퓨터를 가리킨다
        Socket socket = new Socket("localhost", 8888);


    }
}