package com.osk2090.ex12;

public class Exam0620 {
    static class Calculator {
        double rate;

        public Calculator(double rate) {
            this.rate = rate;
        }

        public double year(int money) {
            return money * rate / 100;
        }

        public double month(int money) {
            return money * rate / 100 / 12;
        }

        public double day(int moeny) {
            return moeny * rate / 100 / 265;
        }

    }
    static interface Interest {
        double compute(int money);
    }

    public static void main(String[] args) {
        Calculator c1 = new Calculator(0.5);

        Interest i1 = new Interest() {
            @Override
            public double compute(int money) {
                return c1.month(money);
            }
        };
        System.out.println("년 이자:" + i1.compute(10_0000_0000));
    }

}