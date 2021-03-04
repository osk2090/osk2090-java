package com.osk2090.Exception.ex3;

public class Exam0650 {
    static class A {

    }

    static class B implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다");
        }
    }

    public static void main(String[] args) throws Exception {
        try (B b = new B()) {
            System.out.println("try...");
        }
    }
}