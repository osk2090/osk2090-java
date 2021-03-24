package com.osk2090.concurrent.ex1;

public class Exam0120 {
    //CPU의 시간을 쪼개서 왔다갔다 하면서
    //동시에 실행하고픈 코드가 있다면
    //다음과 같이 Thread를 상속 받아
    //run() 메서드에 그 코드를 두어라

    static class MyThread extends Thread {
        @Override
        public void run() {
            //기존 실행 흐름과 분리하여 따로 실행시킬 코드를
            //이 메서드에 둔다
            for (int i = 0; i < 1000; i++) {
                System.out.println("==> " + i);
            }
        }
    }

    public static void main(String[] args) {
        /*
        동시에 실행할 코드를 담고 있는 Thread 객체를 생성한다
        그리고 현재 실행과 분리하여 작업을 시작시킨다
        JVM은 이 스레드에 들어 있는 코드와 다음과 진행하는 코드를
        왔다갔다 하면서 처리할 것이다
         */
        new MyThread().start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
    }
}
/*
main() 메서드를 실행하는 기본 실행 흐름에서 새로운 실행 흐름으로 분기하고 싶다면
Thread 클래스에 분기해서 실행할 코드를 담으면 된다
그러면 두 개의 실행 흐름이 서로 왔다 갔다 하면서 실행 된다

##멀티태스킹
한개의 CPU가 여러 코드를 동시에 실행 시키는 것
실제는 일정한 시간을 쪼개어 이 코드와 저 코드를 왔다갔다 하면서 실행한다
그럼에도 불구하고 외부에서 봤을 때는 명령어가 동시에 실행되는 것 처럼 보인다
왜?CPU속도가 워낙 빠르기 때문이다

##CPU의 실행 시간을 쪼개어 배분하는 정책:CPU Scheduling 또는 프로세스 스케줄링
CPU의 실행 시간을 쪼개 코드를 실행하는 방법이다

1.Round-Robin
윈도우OS에서 사용하는 방식
CPU 실행 시간을 일정하게 쪼개서 각 코드에 분배하는 방식

2.Priority
유닉스 리눅스에서 사용하는 방식
우선 순위가 높은 코드에 더 많은 실행 시간을 배정하는 방식
문제점
우선 순위가 낮은 프로그램인 경우 CPU 시간을 배정받지 못하는 문제가 발생했다
그래서 몇 년이 지나도록 실행되지 않는 경우가 나타났다
해결책?

 */