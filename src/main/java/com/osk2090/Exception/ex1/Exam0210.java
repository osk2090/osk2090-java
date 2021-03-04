package com.osk2090.Exception.ex1;

import java.util.Scanner;

public class Exam0210 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("입력>");
            String op = scan.next();
            if (op.equalsIgnoreCase("quit")) {
                break;
            }
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();

            int result = Calculator2.compute(op, v1, v1);
            if (result == -1212121212) {
                System.out.println("유효하지 않은 연산자입니다~");
            } else {
                System.out.println(result);
            }
        }
        scan.close();
    }
}