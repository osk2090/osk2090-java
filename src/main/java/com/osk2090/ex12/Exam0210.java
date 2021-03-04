package com.osk2090.ex12;

public class Exam0210 {
    interface Player {
        void play();
    }

    public static void main(String[] args) {
        Player p = () -> System.out.println("Player...");

        p.play();
    }
}