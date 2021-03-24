package com.osk2090.concurrent.ex4;

import java.util.Scanner;

public class Exam0111 {
    public static void main(String[] args) {
        System.out.println("스레드 시작시킴");

        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(">>>> " + i);
            }
            System.out.println("스레드의 run() 실행 종료!");
        });

        t.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

        //죽은 스레드 객채를 또 실행할 수 없다
        t.start();//예외 발생!
        System.out.println("main() 종료!");

    }
}