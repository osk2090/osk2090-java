package com.osk2090.ex12;

public class Exam0120 {
    interface Player {
        void play();
    }

    public static void main(String[] args) {
        Player p1 = () -> {
            System.out.println("데스트");
        };

        Player p2 = new Player() {
            @Override
            public void play() {
                System.out.println("데승트2");
            }
        };
        p2.play();


    }
}