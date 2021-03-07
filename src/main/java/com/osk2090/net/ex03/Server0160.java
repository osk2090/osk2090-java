package com.osk2090.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0160 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket ss = new ServerSocket(8888)) {
            System.out.println("클라이언트의 연결을 기다리고 있음.");

            try (Socket socket = ss.accept();
                 Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
                 PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))) {
                System.out.println("클라이언트가 보낸 한 줄의 문자열을 기다리고 있음!");

                String str = in.nextLine();
                System.out.println(str);

                //서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다
                //이를 확인하기 위해 잠시 실행을 멈춘다
                System.out.print(">");
                scanner.nextLine();

                out.println(str);
                out.flush();
                System.out.println("클라이언트에게 데이터를 보냄.");
            }
            System.out.println("클라이언트와의 연결을 끊었음.");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("서버 종료!");
    }
}