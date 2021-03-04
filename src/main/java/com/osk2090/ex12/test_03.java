package com.osk2090.ex12;

public class test_03 {
    static interface Player {
        void play();
    }

    static void testPlayer(Player player) {
        player.play();
    }

    public static void main(String[] args) {
        //로컬 클래스
        class MyPlayer implements Player {
            @Override
            public void play() {
                System.out.println("플레이!");
            }
        }
        MyPlayer myPlayer = new MyPlayer();

        testPlayer(myPlayer);

        //위의 로컬 클래스를 익명클래스로 바꾼다
       testPlayer(() -> System.out.println("플레이!"));
    }
}