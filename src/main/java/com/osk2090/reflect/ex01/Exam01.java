package com.osk2090.reflect.ex01;

class A {
    static int i;

    static void m() {
        i = 100;
    }

    static{
        System.out.println("A 클래스 로딩!");
    }
}
public class Exam01 {
    public static void main(String[] args) throws Exception {

        //클래스 로딩
        //클래스가 로딩되어 있지 않다는 조건
        //클래스의 스태틱 맴버(변수,메서드)를 사용할 때
        //new 명령을 사용하여 인스턴스를 생성하려 할 때
        //Class.forName()을 이용하여 임의로 클래스를 로딩 할때

        //클래스 로딩 과정에서 하는 일
        //스태틱 변수를 준비한다
        //스태틱 블록을 실행한다

//        A.i = 100;//클래스 로딩 확인
//        A.m();//클래스 로딩 확인
//        new A();//클래스 로딩 확인
//        new A();//클래스는 중복으로 로딩되지 않는다

        Class.forName("com.osk2090.reflect.ex01.A");
        //파라미터로 패키지명을 포함한 전체 클래스 이름을 지정해야 한다
        //패키지명을 포함한 전체 클래스 이름
        //fully qualified class name
        //FQName
        //QName

        A obj = null;
        A[] arr;
        arr = new A[100];
        System.out.println("실행 했음!");
    }
}