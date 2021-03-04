package com.osk2090.net.ex01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender4 {
    public static void main(String[] args) throws Exception {
        File file = new File("README.md");

        FileInputStream fileIn = new FileInputStream(file);//파일 입력받기

        System.out.println("서버에 연결 중...");
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결 완료!");

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());//보낼 준비
        Scanner in = new Scanner(socket.getInputStream());//받을 준비

        System.out.println("서버에 데이터 송신 중...");

        long startTime = System.currentTimeMillis();

        //파일 크기 보내기
        out.writeLong(file.length());

        //파일 이름 보내기
        out.writeUTF(file.getName());

        //파일 데이터 보내기
        int b;
        while ((b = fileIn.read()) != -1) {
            out.write(b);//바이트 형식으로 보낸다
        }

        long endTime = System.currentTimeMillis();

        System.out.printf("서버에 데이터 송신 완료!(%d밀리초)\n", endTime - startTime);

        //서버의 응답받기
        String response = in.nextLine();
        System.out.println(response);

        in.close();
        out.close();
        socket.close();
        fileIn.close();
    }
}