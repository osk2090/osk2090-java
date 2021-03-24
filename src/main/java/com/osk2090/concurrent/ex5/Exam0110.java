package com.osk2090.concurrent.ex5;

//멀티 스레딩(비동기 프로그래밍)의 문제점
public class Exam0110 {

    static class MyList {
        int[] values = new int[100];
        int size;

        public void add(int value) {
            /*
            여러 스레드가 동시에 이 메서드에 진입하면
            배열의 값을 덮어쓰는 문제가 발생한다
            이렇게 여러 스레드가 동시에 접근했을때 문제가 발생하는 코드 부분을
            "Critical Section" 또는 "Critical Region"이라 부른다
             */

            if (size >= values.length) {
                delay();
                return;
            }

            delay();
            values[size] = value;
            delay();
            //여기서 도중에 다른 스레드가 동작될수 있어 그 스레드의 값이 들어갈 수 있다
            size = size + 1;
            delay();
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.printf("%d:  %d\n", i, values[i]);
            }
        }

        public void delay() {
            int count = (int) (Math.random() * 1000);
            for (int i = 0; i < count; i++) {
                Math.atan(34.1234);
            }
        }
    }

    static class Worker extends Thread {
        MyList list = new MyList();
        int value;

        public Worker(MyList list, int value) {
            this.list = list;
            this.value = value;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                list.add(value);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        MyList list = new MyList();

        Worker w1 = new Worker(list, 111);
        Worker w2 = new Worker(list, 222);
        Worker w3 = new Worker(list, 333);

        w1.start();
        w2.start();
        w3.start();

        Thread.sleep(10000);
        list.print();

    }
}
/*
0:  111
1:  111
2:  111
3:  111
4:  111
5:  111
6:  111
7:  111
8:  111
9:  111
10:  111
11:  222
12:  0<---------여기는 두개 이상의 스레드가 동시에 동작해서 0으로 입력된 경우이다
13:  222
14:  111
15:  0
16:  111
17:  222
18:  111
19:  222
20:  111
21:  0
22:  333
23:  111
24:  0
25:  222
26:  0
27:  333
28:  0
29:  222
30:  0
31:  222
32:  333
33:  0
 */