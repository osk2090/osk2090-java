package com.osk2090.ex12;

public class test {
    public interface MP3 {//1.먼저 인터페이스를 만든다
        void playMusic();//2.단 한개의 추상 매서드만 선언한다
    }

    public static void main(String[] args) {
        MP3 mp3 = new MP3() {//3.익명 클래스로 인터페이스를 구현한다
            @Override
            public void playMusic() {
                System.out.println("익명 클래스로 생성된 MP3이다.");
            }
        };
        mp3.playMusic();
        //여기서 람다문법으로 바꿔준다
        /*
        4.이렇게된 구간은 삭제한다
         */
        MP3 mp31 = /*new MP3*/ ()/*<-파라미터가 없다고 괄호 생략 불가능*/ -> {
            /*@Override
            public void playMusic() */{
                System.out.println("익명 클래스를 람다 문법으로 바꿔준 MP3이다.");
            }
        };//5.새미콜론 필수
        mp31.playMusic();

        //람다 완성
        //매서드 한 개짜리 인터페이스를 구현한 익명 클래스를 좀 더 간단히 표현하기 위해 만든 문법이다
        //즉 뻔한 코드를 생략하는 것이다
        MP3 mp311 =() -> { System.out.println("익명 클래스를 람다 문법으로 바꿔준 MP3이다.");};//새미콜론 필수
        mp311.playMusic();
        /*
        람다와 .class 파일
        람다는 해당 클래스의 멤버 메서드로 정의된다
        즉 별도의 .class 파일을 생성하지 않는다
        람다 문법이 초기에 등장했을 때는 익명 클래스로 변환되었다.
        하지만 최근에는 그냥 멤버 메서드로 변환된다.

        ->람다를 호출하는 코드는 자동 생성된 메서드를 호출하는 코드로 변환된다
         */

        //람다와 파라미터
        MP3 mp3111 =() -> {System.out.println("익명 클래스를 람다 문법으로 바꿔준 MP3이다.");};//새미콜론 필수
        mp3111.playMusic();
    }

    public interface PMP {
        void PlayMovie(String fileName);
    }
}