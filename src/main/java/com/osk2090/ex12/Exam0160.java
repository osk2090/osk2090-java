package com.osk2090.ex12;

public class Exam0160 {
    interface A {
        void print();
    }

    static A obj1 = () -> System.out.println("스태틱 필드");

    A obj2 = () -> System.out.println("인스턴스 필드");

    public static void main(String[] args) {
        A obj3 = () -> System.out.println("로컬 변수");

        m1(() -> System.out.println("파라미터"));
        m1(() -> System.out.println("ㅁㅁㅁ"));
    }

    static void m1(final A obj) {
        obj.print();
    }
}