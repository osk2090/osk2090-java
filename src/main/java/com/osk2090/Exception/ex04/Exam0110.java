package com.osk2090.Exception.ex04;

public class Exam0110 {
    static void m1() {
        System.out.println("m1시작");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m1->m2");
        m2();
    }

    static void m2() {
        System.out.println("m2시작");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m2->m3");
        m3();
    }

    static void m3() {
        System.out.println("m3시작");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m3->m4");
        m4();
    }

    static void m4() {
        System.out.println("m4시작");

        System.out.println("m4() 실행됨");
    }

    public static void main(String[] args) {
        m1();
    }
}