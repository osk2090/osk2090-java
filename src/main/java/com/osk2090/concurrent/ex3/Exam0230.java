package com.osk2090.concurrent.ex3;

//람다로 구현하기
public class Exam0230 {
    public static void main(String[] args) {
        new Thread(()-> {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();


        new Thread(() ->{
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }

        }).start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("===> " + i);
            }
        }).start();



        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
    }
}