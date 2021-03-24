package com.osk2090.concurrent.ex3;

public class Exam0220 {
    public static void main(String[] args) {
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println("===> " + i);
//                }
//            }
//        }.start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

//        new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println("===> " + i);
//            }
//
//        }).start();

//        new Thread(() -> {for (int i = 0; i < 1000; i++) {System.out.println("===> " + i);} }).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
    }
}