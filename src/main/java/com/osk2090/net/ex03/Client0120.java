package com.osk2090.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8888);
             OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {
            System.out.println("서버와 연결되었음!");

            //서버에 데이터를 보내기 전에 잠깐 멈춤!
            System.out.print(">");
            scanner.nextLine();

            //서버에 보낼 바이트 배열을 준비한다
            //0~99의 값을 가진 배열이다
            byte[] bytes = new byte[100];
            for (int i = 0; i < 100; i++) {
                bytes[i] = (byte) i;
            }

            //서버에 바이트 배열을 전송한다
            out.write(bytes);

            System.out.println("서버에 데이터를 보냈음");

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}