package com.osk2090.net.ex01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver5 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        ServerSocket serverSocket = new ServerSocket(8888);//포트 선언
        Socket socket = serverSocket.accept();//클라이언트를 받을 준비
        System.out.println("클라이언트가 연결됨.");

        //버퍼를 데코레이터로 선언->속도가 빨라질것이다
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));//배출
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));//받음

        System.out.println("클라이언트로부터 데이터 수신 중...");

        //1.파일 크기 읽기
        long filesize = in.readLong();

        //2.파일 이름 읽기
        String fileName = in.readUTF();

        //3.파일 데이터 읽기
        File file = new File("steam_" + fileName);
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file));

        for (long i = 0; i < filesize; i++) {
            fileOut.write(in.read());
        }
        System.out.println("클라이언트로부터 데이터 수신완료!");

        //4.클라이언트에게 응답하기
        out.print("complete");
        out.flush();//버퍼에 남아있는 데이터 방출하기

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        fileOut.close();
    }
}