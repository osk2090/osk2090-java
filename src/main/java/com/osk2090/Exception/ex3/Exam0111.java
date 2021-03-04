package com.osk2090.Exception.ex3;

public class Exam0111 {

    static void m() {
        //예외를 호출자에게 알려주는 문법
        throw new RuntimeException("예외가 발생했습니다");
    }

    static void test() {
        m();
        //m() 메서드가 던진 예외를 받지 않으면?
        //즉시 현재 메서드의 실행을 멈추고 호출자에게 예외 처리를 위임한다

        //따라서 다음 출력 코드는 실행되지 않는다
        System.out.println("test() 호출됨!");
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("시스템을 종료합니다");
    }
}