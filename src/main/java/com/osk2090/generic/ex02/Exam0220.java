package com.osk2090.generic.ex02;

import java.util.ArrayList;

public class Exam0220 {
    static class A {

    }

    static class B1 extends A {

    }

    static class B2 extends A {
    }

    static class C extends B1 {
    }

    public static void main(String[] args) {
        m1(new ArrayList());
    }

    static void m1(ArrayList list) {
        list.add(new Object());
        list.add(new A());
        list.add(new B1());
        list.add(new B2());
        list.add(new C());

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

    }
}