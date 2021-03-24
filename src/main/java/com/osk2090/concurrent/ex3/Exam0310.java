package com.osk2090.concurrent.ex3;

import java.util.Scanner;

public class Exam0310 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("입력하세요>");
            String input = scanner.nextLine();
            System.out.println("입력한 문자열 => " + input);
            scanner.close();
        }
    }

    public static void main(String[] args) {
        /*
        main 스레드에서 새 스레드 객체 생성하기
        어떤 스레드에서 만든 스레드를 그 스레드의 자식 스레드라 부른다
        즉 다음 스레드는 main 스레드의 자식 스레드이다
        자식 스레드는 부모 스레드와 같은 우선 순위를 갖느ek
        */
        MyThread t = new MyThread();
        t.start();

        //모든 스레드가 완료할 때까지 JVM은 종료되지 않는다
        System.out.println("프로그램 중료?");

    }
}