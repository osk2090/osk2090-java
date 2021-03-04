package com.osk2090.ex12;

public class test_02 {
    public interface IPAD {
        void use(String gameName, double version);
    }

    public static void main(String[] args) {
       IPAD ipad = new IPAD() {//1.인터페이스 구현
           @Override
           public void use(String gameName, double version) {
               System.out.printf("%s %.1f version 게임을 하고있습니다.\n", gameName, version);
           }
       };
        ipad.use("앵그리버드", 2.5);
        System.out.println("===============================");

        //1.파라미터는 괄호() 안에 선언한다
        IPAD ipad1 = (String gameName, double version) -> System.out.printf("%s %.1f version 게임을 하고있습니다.\n", gameName, version);

        ipad.use("모두의 마블", 5.0);
        System.out.println("===============================");

        //2.파라미터 타입을 생략할 수 있다
        IPAD ipad2 = (gameName, version) -> System.out.printf("%s %.1f version 게임을 하고있습니다.\n", gameName, version);

        ipad.use("리니지", 3.1);
        System.out.println("===============================");

        //3.파라미터가 여러 개일 때는 괄호를 생략할 수 없다
//        IPAD ipad3 = gameName, version -> System.out.printf("%s %d.version 게임을 하고있습니다.", gameName, version);

    }
}