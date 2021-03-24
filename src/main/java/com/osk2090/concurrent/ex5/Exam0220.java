package com.osk2090.concurrent.ex5;

public class Exam0220 {

    static class Account {
        String accountId;
        long balance;

        public Account(String accountId, long balance) {
            this.accountId = accountId;
            this.balance = balance;
        }
        /*
        한 번에 한 스레드 만이 호출되도록 접근을 제한하고 싶다면
        메서드 전체를 동기화 블록으로 선언하라
        어떻게
        메서드 앞에 synchronized를 붙인다
        여러 스레드가 동시에 접근했을 때 문제가 발생하지 않는 코드에 대해
        synchronized 사용한다면 실행 속도가 떨어질 것이다
        왜
        한 번에 한 스레드만 순차적으로 접근하기 때문이다

        이렇게 크리티컬 섹션에 동시에 접근하지 못하게 하는 기법
        뮤텍스 또는 세마포어(1)라 부른다

        자바에서 뮤텍스를 구현하는 방법
        크리티컬 섹션에 해당하는 메서드나 코드 블록에
        synchronized 키워드를 붙여
        한 번에 한 스레드만 진입할 수 있도록 lock을 건다

        참고
        여러 스레드가 동시에 실행해도 문제가 없는 코드 블록을
        스레드 안전 이라고 부른다
         */

        synchronized public long withdraw(long money) {
            long b = this.balance;

            delay();
            b -= money;
            delay();
            if (b < 0) {
                return 0;
            }
            delay();
            this.balance = b;
            delay();
            return money;
        }

        private void delay() {
            int delayCount = (int) (Math.random() * 1000);
            for (int i = 0; i < delayCount; i++) {
                Math.atan(45.765);
            }
        }

        static class ATM extends Thread {
            Account account;

            public ATM(String name, Account account) {
                super(name);
                this.account = account;
            }

            @Override
            public void run() {
                long money = 0;
                long sum = 0;

                while (true) {
                    money = account.withdraw(100);
                    if (money <= 0) {
                        break;
                    }
                    sum += money;
                    System.out.printf("%s에서 찾은 돈: %d원\n", this.getName(), sum);
                }
            }

            public static void main(String[] args) {
                Account account = new Account("111-11-1111-111", 100_0000);

                ATM 강남 = new ATM("강남", account);
                ATM 서초 = new ATM("서초", account);
                ATM 부산 = new ATM("부산", account);
                ATM 대전 = new ATM("대전", account);
                ATM 광주 = new ATM("광주", account);

                /*
                비동기 문제 해결책
                한 번에 한 스레드 만이 크리티컬 섹션을 실행하도록 접근을 제한하면 된다

                주의
                동시에 여러 스레드가 같은 메모리에 접근하더라도
                값을 변경하는 것이 아니라 단순히 값을 조회하는 경우에는
                멀티 스레드 문제가 발생하지 않는다


                 */
            }
        }
    }
}