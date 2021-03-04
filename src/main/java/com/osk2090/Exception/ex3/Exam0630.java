package com.osk2090.Exception.ex3;

import java.io.FileReader;
import java.util.Scanner;

public class Exam0630 {
    static void m()throws Exception {
        try (Scanner scan = new Scanner(System.in);
             // FileReader 클래스도 java.lang.AutoCloseable 구현체이다.
             FileReader in = new FileReader("Hello,java")
        ) {
            System.out.println("입력>");
            int value = scan.nextInt();
            System.out.println(value * value);
        }
    }

    public static void main(String[] args) {
        try {
            m();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}