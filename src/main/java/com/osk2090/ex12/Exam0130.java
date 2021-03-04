package com.osk2090.ex12;

public class Exam0130 {
    interface Player {
        void play(String name);
    }

    public static void main(String[] args) {
        Player p1 = (String name) ->
                System.out.println(name + "님 환영합니다.");
        p1.play("오은석");

        Player p2 = (name) -> System.out.println(name + "님 환영합니다.");
        p2.play("111");

        Player p3 = name -> System.out.println(name + "님 환영합니다.");
        p3.play("222");

    }
}
