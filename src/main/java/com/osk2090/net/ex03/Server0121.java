package com.osk2090.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0121 {
    public static void main(String[] args) {
        //소켓을 연결한 후에 꼭 클라이언트가 먼저 데이터를 보낼 필요는 없다
        //서버가 먼저 데이터를 보내도 된다
        //즉 읽고 쓰기 순서만 맞으면 누가 먼저 보내든지 상관없다
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket ss = new ServerSocket(8888)) {
            System.out.println("클라이언트의 연결을 기다리고 있음.");

            try (Socket socket = ss.accept();
                 OutputStream out = socket.getOutputStream();
                 InputStream in = socket.getInputStream()) {
                System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");
                System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");

                System.out.println("데이터를 보내기 전에 잠깐!");
                scanner.nextLine();

                byte[] buf = new byte[100];
                for (int i = 0; i < buf.length; i++) {
                    buf[i] = (byte) i;
                }

                //클라이언트에서 받은 바이트 개수 만큼 배열을 출력한다
                out.write(buf);
                System.out.println("클라이언트에게 데이터를 보냈음.");
            }
            System.out.println("클라이언트와의 연결을 끊었음.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("서버 종료!");
    }
}