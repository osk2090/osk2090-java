package com.osk2090.generic.ex02;

public class Exam0312 {
    static interface Player {
        void play();
    }

    static void testPlayer(Player player) {
        player.play();
    }

    public static void main(String[] args) {
        testPlayer(new Player() {
            @Override
            public void play() {
                System.out.println("실행~~~");
            }
        });
    }
}