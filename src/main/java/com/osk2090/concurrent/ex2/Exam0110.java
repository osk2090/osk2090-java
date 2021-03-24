package com.osk2090.concurrent.ex2;

public class Exam0110 {
    public static void main(String[] args) {
        /*
        JVM은 여러 개의 스레드를 실행한다
        main()호출도 별도의 스레드가 실행한다
         */

        Thread t = Thread.currentThread();
        System.out.println("실행 흐름명:" + t.getName());
    }
}