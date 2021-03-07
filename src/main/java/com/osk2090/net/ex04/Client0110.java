package com.osk2090.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0110 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8888);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("서버와 연결되었음!");

            String name = null;
            do {
                System.out.println("이름? ");
                name = scanner.nextLine();

                out.print(name);
                out.flush();

                String str = in.readLine();
                System.out.println(str);

            } while (!name.equalsIgnoreCase("quit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}