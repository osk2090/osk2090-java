package com.osk2090.Exception.ex3;

public class Exam0112 {

    static void m() {
        throw new RuntimeException("예외가 발생했습니다");
    }

    static void test() {
        m();

        System.out.println("test() 호출됨!");
    }

    public static void main(String[] args) {
        /*
        애플리케이션 실행의 최후의 보루인 main()에서 예외를 처리하지 않는다면?
        발생한 그 예외는 jvm에게 전달 된다
        그렇게되면 무조건 예외 정보를 출력한 후 프로그램을 종료한다
         */

        test();


//        try {해결책
//            test();
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("시스템을 종료합니다");
    }
}