package com.osk2090.net.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
연결지향
연결 후에 데이터를 송수신하기 때문에 데이터 송수신에 대한 신뢰를 보장한다
TCP 통신 방법이 전형적인 예이다
 */
public class Server0110 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("서버 실행 중...");
        ServerSocket ss = new ServerSocket(8888);

        System.out.println("엔터를 치면 대기열에서 시다리고 있는 클라이언트의 소켓을 생성한다>");
        scanner.nextLine();

        Socket socket = ss.accept();
        System.out.println("클라이언트와 통신할 소켓을 준비하였다!");

        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());

        String str = in.nextLine();
        System.out.println("데이터 수신 완료!");

        out.println(str);
        System.out.println("데이터 송신 완료!");

        in.close();
        out.close();
        socket.close();
        System.out.println("클라이언트 연결 끊기!");

        ss.close();
        scanner.close();
    }
}