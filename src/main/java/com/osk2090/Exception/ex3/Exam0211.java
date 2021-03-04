package com.osk2090.Exception.ex3;

public class Exam0211 {
    static void m1() throws Error {
        throw new Error();
    }

    static void m2() {
        throw new Error();
    }

    public static void main(String[] args) {
        m1();
    }
}