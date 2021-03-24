package com.osk2090.concurrent.ex2;

public class Exam0140 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        ThreadGroup[] groups = new ThreadGroup[100];
        int count = mainGroup.enumerate(groups, false);

        for (int i = 0; i < count; i++) {
            System.out.println("  => " + groups[i].getName());
        }
    }
}