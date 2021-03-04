package com.osk2090.net.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행!");

        Scanner keyScan = new Scanner(System.in);

        ServerSocket serverSocket = new ServerSocket(8888);//포트 생성
        Socket socket = serverSocket.accept();//accept() 하면 대기열에서 순서대로 꺼내 해당 클라이언트와 연결되는 소켓을 만든다

        PrintStream out = new PrintStream(socket.getOutputStream());//배출
        Scanner in = new Scanner(socket.getInputStream());//가져옴

        String str = in.nextLine();//클라이언트가 보낸 문자열을 받는다
        System.out.println(str);

        //키보드 입력을 받아서 클라이언트로 송신한다
        System.out.print("입력> ");
        str = keyScan.nextLine();
        out.println(str);//문자열을 보낸다

        in.close();
        out.close();
        serverSocket.close();
        socket.close();
        keyScan.close();
    }
}