package com.osk2090.concurrent.ex4;

public class Exam0110 {
    public static void main(String[] args) {
        System.out.println("스레드 실행 전");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

        System.out.println("스레드 실행 후");
        //main() 메서드의 호출이 끝나더라도 다른 스레드의 실행이 종료될 때까지
        //JVM은 종료되지 않는다
    }
}