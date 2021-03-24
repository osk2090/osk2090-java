package com.osk2090.concurrent.ex2;

public class Exam0120 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        //스레드는 그룹에 소속되기도 한다
        //현재 스레드의 소속 그룹을 알고 싶다면
        ThreadGroup group = main.getThreadGroup();
        System.out.println("그룹명:" + group.getName());

        //main()메서드를 호출하는 스레드는 main tmfpemdlrh
        //main 스레드가 소속된 그룹은 main 그룹이다
    }
}