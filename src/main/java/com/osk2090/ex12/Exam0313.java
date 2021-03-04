package com.osk2090.ex12;

public class Exam0313 {
    static interface Player {
        void play();
    }

    static void testPlayer(Player player) {
        player.play();
    }

    public static void main(String[] args) {
        testPlayer(()-> System.out.println("실행ㅁㄹㅁㄴㄹㅇ"));
    }
}