package com.osk2090.reflect.ex01;

public class Exam03 {
    static class A {
        static int s_var = 100;
        int i_var = 200;

        static void s_m() {

        }

        void a_m() {

        }

        static {
            System.out.println("A 클래스 로딩!");
        }
    }

    public static void main(String[] args) throws Exception {
        //다음은 클래스를 로딩한 후 스태틱 필드를 생성하고 스태틱 블록을 실행 한다
//        Class clazz = Class.forName("com.osk2090.reflect.ex01.Exam03$A");
        System.out.println("------------------------------");

        //자바의 모든 클래스는 "class"라는 특별한 스태틱 변수를 갖고 있다
        //"class" 변수에는 해당 클래스의 정보를 담은 Class 객체의 주소가 저장되어 있다
        Class clazz1 = A.class;
        //하지만 이 방식은 static{} 블록을 실행하지 않는다
    }
}