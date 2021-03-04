package com.osk2090.ex12;

public class Exam0520 {

    static class MyCalculator {
        public static int plus(int a, int b) {
            return a + b;
        }

        public static int minus(int a, int b) {
            return a - b;
        }

        public static int multiplus(int a, int b) {
            return a * b;
        }

        public static int divide(int a, int b) {

            return a / b;
        }
    }

    interface Calculator {
        int compute(int x, int y);
    }

    public static void main(String[] args) {
        //스태틱 메서드 레퍼런스로 Calculator 구현체를 만드는 방법
        //Calculator c1 = MyCalculator()::plus;
        //위의 코드는 내부적으로 다음과 같다

     Calculator c1 = new Calculator() {
         @Override
         public int compute(int a, int b) {
             /*
             기존 메서드가 메서드 레퍼런스로 전달 가능한지 여부는
             다음 코드를 참고한다
             인터페이스에 정의된 메서드(예: compute())가 호출되었을때

             그 파라미터 값은 메서드 레퍼런스로 지정된
             스태틱 메서드(예: plus())에게 전달될 것이다
             그래서 스태틱 메서드의 파라미터는 항상
             인터페이스 메서드에 정의된 파라미터 값을 받을 수 있어야 한다

             스태틱 메서드의 리턴값은
             인터페이스 메서드에 정의된 대로 리털할 수 있어야 한다
             그래서 스태틱 메서드의 리턴 타입은
             인터페이스 메서드의 리턴 타입과 일치하거나
             그 타입으로 바꿀 수 있어야 한다
              */
             return MyCalculator.plus(a, b);
         }
     };
        System.out.println(c1.compute(200, 17));
    }
}