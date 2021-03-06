package com.osk2090.ex12;

public class Exam0530 {
    static class MyCalculator {
        public static int plus(int a, int b) {
            return a + b;
        }

        public static int minus(int a, int b) {
            return a - b;
        }

        public static int multiple(int a, int b) {
            return a * b;
        }

        public static int divide(int a, int b) {
            return a / b;
        }
    }

    interface Calculator1 {
        double compute(int a, int b);
    }

    interface Calculator2 {
        float compute(int a, int b);
    }

    interface Calculator3 {
        short compute(int a, int b);
    }

    interface Calculator4 {
        void compute(int a, int b);
    }

    interface Calculator5 {
        Object compute(int a, int b);
    }

    interface Calculator6 {
        String compute(int a, int b);
    }

    public static void main(String[] args) {
        Calculator1 c1 = MyCalculator::plus;

        System.out.println(c1.compute(100, 200));

        Calculator2 c2 = MyCalculator::plus;
        System.out.println(c2.compute(100, 200));

        Calculator4 c4 = MyCalculator::plus;
        c4.compute(100, 200);

        Calculator5 c5 = MyCalculator::plus;
        System.out.println(c5.compute(100, 200));

        /*
        메서드 레퍼런스를 지정할 때 리턴 타입의 규칙
        1.같은 리턴 타입
        2.암시적 형변환 가능한 타입
        3.오토 박싱 간으한 타입
        4.void

        결론
        메서드 레퍼런스가 가리키는 실제 메서드를 호출한 후
        그 메서드가 리턴한 값이
        인터페이스에 정의된 메서드의 리턴 값으로 사용할 수 있다면
        문제가 없다
         */
    }
}