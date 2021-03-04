package com.osk2090.generic.ex02;

import java.util.ArrayList;

public class Exam0213 {
    static class A {

    }

    static class B1 extends A {
    }

    static class B2 extends A {
    }

    static class C extends B1 {
    }

    public static void main(String[] args) {
        ArrayList<A> list;

        list = new ArrayList<>();
        list = new ArrayList<>();
        list = new ArrayList<A>();

        list.add(new B2());

        ArrayList<B2> list1;
        list1 = new ArrayList<>();

    }
}