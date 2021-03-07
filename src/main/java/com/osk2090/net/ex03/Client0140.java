package com.osk2090.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0140 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 8888);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            System.out.println("서버와 연결되었음!");

            //서버에 데이터를 보내기 전에 잠깐 멈춤!
            System.out.print(">");
            scanner.nextLine();

            out.writeInt(1567891234);
            out.writeByte(100);
            out.writeFloat(3.14f);
            out.writeUTF("ABC가각간");

            System.out.println("서버에 데이터를 보냈음!");

            int value = in.readInt();
            byte value2 = in.readByte();
            float value3 = in.readFloat();
            String value4 = in.readUTF();

            System.out.printf("%d. %d. %f. %s\n", value, value2, value3, value4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}