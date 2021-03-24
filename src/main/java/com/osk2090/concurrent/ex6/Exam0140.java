package com.osk2090.concurrent.ex6;

import java.util.Scanner;

public class Exam0140 {
    public static void main(String[] args) {

        class ValueBox {
            int count;

            synchronized public void setCount(int count) {
                this.count = count;
                this.notify();//동기화 영역에서 호출해야 한다
            }
        }

        class MyThread extends Thread {
            ValueBox valueBox;

            public void setValueBox(ValueBox valueBox) {
                this.valueBox = valueBox;
            }

            @Override
            public void run() {
                System.out.println("스레드 시작했음!");

                try {
                    while (true) {
                        System.out.println("스레드 대기중...");

                        //해당 객체에서 notify()를 통해 알림이 오기전까지 실행을 멈추게 한다
                        //wait()/notify()는 반드시 동기화 영역 안에서 호출해야 한다
                        //여기서 동기화 부분이란 synchronized로 선언한 메서드를 말한다

                        synchronized (valueBox) {
                            valueBox.wait();//해당 객체는 신호가 오기 전까지 기다리고 있으라는 뜻이다.
                            //기다림을 끝내는 방법은
                            //notify()를 통해 얼음땡을 해줘야 한다
                        }
                        System.out.println("카운트 시작!");
                        for (int i = 0; i < valueBox.count; i++) {
                            System.out.println("==> " + i);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        ValueBox valueBox = new ValueBox();

        MyThread t = new MyThread();
        t.setValueBox(valueBox);
        t.start();//이 스레드는 main 스레드가 실행하라고 신호를 줄 때까지 기다린다

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("카운트?");
            String str = scanner.nextLine();
            if (str.equals("quit")) {
                break;
            }
            valueBox.setCount(Integer.parseInt(str));
            
        }
        System.out.println("main 스레드 종료!");
        scanner.close();

    }
}