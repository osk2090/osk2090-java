package com.osk2090.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender2 {
    public static void main(String[] args) throws Exception {
        System.out.println("클라이언트 실행!");
        Scanner keyScan = new Scanner(System.in);//스캐너 생성

        Socket socket = new Socket("localhost", 8888);//입장할 ip와 포트 입력

        PrintStream out = new PrintStream(socket.getOutputStream());//배출될 준비
        Scanner in = new Scanner(socket.getInputStream());//받을 준비

        //키보드 입력을 받아서 서버에게 보낸다
        System.out.println("입력> ");
        String str = keyScan.nextLine();
        out.println(str);//보냄

        str = in.nextLine();//서버가 보낸 문자를 가져온다
        System.out.println(str);

        in.close();
        out.close();
        keyScan.close();
        socket.close();
    }
}