package com.osk2090.net.ex01;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver4 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");

        ServerSocket serverSocket = new ServerSocket(8888);//포트번호 선언
        Socket socket = serverSocket.accept();//대기열에서 클라이언트를 받는다
        System.out.println("클라이언트가 연결됨.");

        PrintStream out = new PrintStream(socket.getOutputStream());//보냄
        DataInputStream in = new DataInputStream(socket.getInputStream());//받음

        System.out.println("클라이언트로부터 데이터 수신중...");

        //1.파일 크기 읽기
        long filesize = in.readLong();

        //2.파일 이름 읽기
        String fileName = in.readUTF();

        //3.파일 데이터 읽기
        File file = new File("steam_" + fileName);
        FileOutputStream fileOut = new FileOutputStream(file);//해당 파일을 배출

        for (long i = 0; i < filesize; i++) {
            fileOut.write(in.read());//바이트로 보내기 때문에 느리다
        }
        System.out.println("클라이언트로 부터 데이터 수신 완료!");

        out.println("complete");

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        fileOut.close();
    }
}