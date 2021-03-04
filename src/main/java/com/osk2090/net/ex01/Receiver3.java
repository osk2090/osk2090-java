package com.osk2090.net.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver3 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행!");

        Scanner scanner = new Scanner(System.in);

        ServerSocket serverSocket = new ServerSocket(8888);//서버입장에서 만듬
        Socket socket = serverSocket.accept();//accept() 하면 대기열에서 순서대로 꺼내 해당 클라이언트와 연결되는 소켓을 만든다

        PrintStream out = new PrintStream(socket.getOutputStream());//배출
        Scanner in = new Scanner(socket.getInputStream());//가져옴

        while (true) {
            //클라이언트가 보낸 문자열을 수신한다
            String str = in.nextLine();
            System.out.println(str);

            //키보드 입력을 받아서 클라이언트로 송신한다
            System.out.print("입력> ");
            String input = scanner.nextLine();
            out.println(input);//클라이언트에게 보냄

            if (str.equals("quit")) {//클라이언트가 연결을 끊는다고하면 끊는다
                break;
            }
        }

        in.close();
        out.close();
        scanner.close();
        socket.close();
    }
}