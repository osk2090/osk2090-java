package com.osk2090.net.ex03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8888);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("서버와 연결되었음!");

            //서버에 데이터를 보내기 전에 잠깐 멈춤!
            System.out.print(">");
            scanner.nextLine();

            out.println("ABC가각간");
            out.flush();
            System.out.println("서버에 데이터를 보냈음");

            String str = in.readLine();
            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}