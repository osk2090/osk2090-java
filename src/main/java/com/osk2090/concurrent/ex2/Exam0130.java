package com.osk2090.concurrent.ex2;

public class Exam0130 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        Thread[] arr = new Thread[100];
        int count = mainGroup.enumerate(arr, false);

        for (int i = 0; i < count; i++) {
            System.out.println(" => " + arr[i].getName());
        }
    }
}