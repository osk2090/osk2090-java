package com.osk2090.net.ex01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Sender5 {
    public static void main(String[] args) throws Exception {
        File file = new File("README.md");

        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));

        System.out.println("서버에 연결 중...");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결 완료!");

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));

        System.out.println("서버에 데이터 손신 중...");

        long startTime = System.currentTimeMillis();

        //1.파일 크기 보내기
        out.writeLong(file.length());

        //2.파일 이름 보내기
        out.writeUTF(file.getName());

        //3.파일 데이터 보내기
        int b;
        while ((b = fileIn.read()) != -1) {
            out.write(b);
        }
        out.flush();
        long endTime = System.currentTimeMillis();

        System.out.printf("서버에 데이터 송신완료!(%d밀리초)\n", endTime = startTime);

        //4.서버의 응답받기
        String response = in.nextLine();
        System.out.println(response);

        in.close();
        out.close();
        socket.close();
        fileIn.close();
    }
}