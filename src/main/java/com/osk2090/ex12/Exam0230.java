package com.osk2090.ex12;

public class Exam0230 {
    interface Player {
        static String info() {//스태틱이라 바로 생성 가능
            return "Plyaer 입니다.";
        }

        default void stop() {

        }

        void play();
    }

    public static void main(String[] args) {
        Player p1 = () -> System.out.println("Player...");

        p1.play();
        System.out.println(Player.info());

    }
}