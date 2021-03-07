package com.osk2090.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0130 {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 8888);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            System.out.println("서버와 연결되었고, 입출력 스트림도 준비되었음!");

            //서버에 데이터를 보내기 전에 잠깐 멈춤!
            System.out.print(">");
            scanner.nextLine();

            out.writeInt(1567891234);
            System.out.println("서버에 데이터를 보냄!");

            int value = in.readInt();
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}