package com.osk2090.net.ex02;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0430 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ServerSocket ss = new ServerSocket(8888, 2);
        System.out.println("클라이언트 연결을 기다리는 중...");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            //대기열에서 꺼내는 순간 대기열은 한 칸 빈다
            //즉 다른 클라이언트 연결을 수용할 수 있다
            Socket socket = ss.accept();
            System.out.println("대기 중인 클라이언트 중 한 개의 클라이언트에 대해 연결 승인!");
        }
        ss.close();
        System.out.println("서버 종료!");
        scanner.close();
    }
}

