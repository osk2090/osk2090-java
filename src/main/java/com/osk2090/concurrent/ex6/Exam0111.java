package com.osk2090.concurrent.ex6;

import java.util.Scanner;

public class Exam0111 {
    public static void main(String[] args) {

        class MyThread extends Thread {
            int count;

            public void setCount(int count) {
                this.count = count;
            }

            @Override
            public void run() {
                try {
                    for (int i = count; i > 0; i--) {
                        System.out.println("==> " + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //카운트를 수행할 스레드를 미리 만든다
        MyThread t = new MyThread();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("카운트? ");
            String str = scanner.nextLine();
            if (str.equals("quit")) {
                break;
            }

            //사용자가 카운트 값을 입력하면
            int count = Integer.parseInt(str);

            //기존에 생성한 스레드에 카운트 값을 설정한 후 실행을 시작시킨다
            t.setCount(count);
            t.start();
            /*
            문제점
            한 번 실행이 완료된 Dead 상태의 스레드는 다시 시작시킬수 없다
            다시 시작하려고 하면 예외가 발생한다
            즉 run() 메서드 호출이 끝나 Dead 상태가 된 스레드는 다시 start()할 수 없다
             */
        }

        System.out.println("main 스레드 중료!");
        scanner.close();
    }
}