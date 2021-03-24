package com.osk2090.concurrent.ex5;

//멀티 스레딩(비동기 프로그래밍)의 문제점
public class Exam0120 {

    static class MyList{
        int[] values = new int[100];
        int size;
        /*
        Critical Section에 오직 한 개의 스레드만 접근하게 하면
        비동기로 인한 문제가 발생하지 않는다
        즉 동기화로 처리한다
        동기화?
        여러 스레드가 동시에 실행하는 것이 아니고
        여러 스레드가 순차적으로 접근하는 것이다
        간 순차적으로 실행한다는 것은 동시 실행의 이점을 버리는 것이기 때문에
        스레드를 사용하기 전의 상태와 같다
        기존의 실행 방식 처럼 실행 시간이 많이 걸린다

        다음 메서드를 동기화 처리해 보자
        synchronized
        이 키워드가 붙은 블록은 오직 한 번에 한 개의 스레드만이 접근할 수 있다
        먼저 접근한 스레드가 나가야만 다음 스레드가 진입할 수 있다
         */

        synchronized public void add(int value) {
            if (size >= values.length) {
                delay();
                return;
            }

            delay();
            values[size] = value;
            delay();
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
        MyList list;
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
11:  111
12:  111
13:  111
14:  111
15:  111
16:  111
17:  111
18:  111
19:  111
20:  333
21:  333
22:  333
23:  333
24:  333
25:  222
26:  222
27:  222
28:  333
29:  333
30:  333
31:  333
32:  333
33:  333
34:  333
35:  333
36:  222
37:  222
38:  222
39:  222
40:  222
41:  222
42:  222
43:  222
44:  222
45:  222
46:  222
47:  222
48:  222
49:  333
50:  333
51:  222
52:  222
53:  222
54:  222
55:  333
56:  333
57:  333
58:  333
59:  333

도중에 0이 나오는 현상이 없이 111과 222 333이 각자 번갈아가면서 값이 들어갔다
 */