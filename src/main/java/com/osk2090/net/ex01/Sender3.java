package com.osk2090.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender3 {
    public static void main(String[] args) throws Exception {
        System.out.println("클라이언트 실행!");

        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("localhost", 8888);//클라이언트 입장

        PrintStream out = new PrintStream(socket.getOutputStream());//배출
        Scanner in = new Scanner(socket.getInputStream());//가져옴

        while (true) {
            System.out.print("입력> ");
            String input = scanner.nextLine();
            out.println(input);

            System.out.println("서버가 보낸 텍스트");
            String str = in.nextLine();
            System.out.println(str);

            if (input.equals("quit")) {//클라이언트가 보낸 문자가 quit이면 정지
                break;
            }
        }
        in.close();
        out.close();
        scanner.close();
        socket.close();
    }
}