package com.osk2090.net.ex04.stateful2;

import com.osk2090.io.ex09.step1.DataInputStream;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");

        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            try (Socket socket = ss.accept()) {

            }
        }
    }

    static void processRequest(Socket socket) throws Exception {
        try (Socket socket1 = socket;
             DataInputStream in = new DataInputStream(socket.getInputStream());
             PrintStream out = new PrintStream(socket.getOutputStream())) {
            int result = 0;

            loop:
            while (true) {
                String op = in.readUTF();
                int a = in.readInt();

                switch (op) {
                    case "+":
                        result += a;
                        break;
                    case "-":
                        result -= a;
                        break;
                    case "*":
                        result *= a;
                        break;
                    case "/":
                        result /= a;
                        break;
                    case "quit":
                        break loop;
                    default:
                        System.out.println("해당 연산을 지원하지 않습니다.");
                        continue;
                }
                out.printf("계산 결과: %d\n", result);
            }
            out.println("bye");
        }
    }
}