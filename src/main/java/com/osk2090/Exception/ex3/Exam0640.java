package com.osk2090.Exception.ex3;

public class Exam0640 {
    static class A {

    }

    static class B {
        public void close()throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다");
        }
    }

    static class C implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("C 클래스의 자원을 해제하였습니다");
        }
    }

    public static void main(String[] args) throws Exception {
        try (C c = new C();) {
            System.out.println("try 블록 실행");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}