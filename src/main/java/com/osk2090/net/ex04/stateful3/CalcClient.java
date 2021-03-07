package com.osk2090.net.ex04.stateful3;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.println("연산자?");
            out.writeUTF(scanner.nextLine());

            System.out.println("값?");
            out.writeInt(Integer.parseInt(scanner.nextLine()));

            String str = in.nextLine();
            System.out.println(str);

            if (str.equals("bye")) {
                break;
            }
            in.close();
            out.close();
            socket.close();
            scanner.close();
        }
    }
}