package com.osk2090.ex12;

public class Exam0140 {
    interface Player {
        void play(String name, int age);
    }

    public static void main(String[] args) {
        Player p1 = (String name, int age) -> System.out.printf("%s(%d)님 환영합니다.\n", name, age);
        p1.play("오은석", 29);

        Player p2 = (name, age) -> System.out.printf("%s(%d)님 환영합니다.\n", name, age);
        p2.play("홍길동", 100);
    }
}