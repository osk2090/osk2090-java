package com.osk2090.ex12;

public class test_01 {
    public interface PMP {
        void PlayMovie(String fileName);
    }

    public static void main(String[] args) {
        PMP pmp = new PMP() {//인터페이스 구현
            @Override
            public void PlayMovie(String fileName) {
                System.out.println(fileName + "영화 시청중...");
            }
        };

        //1.파라미터는 괄호() 안에 선언한다
        PMP pmp1 = (String fileName) ->System.out.println(fileName + "영화 시청중...");

        pmp1.PlayMovie("터미네이터2");

        System.out.println("===============================");

        //2.파라미터 타입을 생략할 수 있다
        PMP pmp2 = (fileName) ->System.out.println(fileName + "영화 시청중...");

        pmp2.PlayMovie("백투더 퓨쳐2");

        System.out.println("===============================");

        //2.파라미터가 한 개일 때는 괄호도 생략할 수 있다
        PMP pmp3 = fileName -> System.out.println(fileName + "영화 시청중...");

        pmp3.PlayMovie("캐치미 이프 유캔");

        System.out.println("===============================");
    }
}