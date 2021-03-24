package com.osk2090.concurrent.ex5;

public class Exam0210 {

    static class Account {
        String accountId;
        long balance;

        public Account(String accountId, long balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public long withdraw(long money) {
            /*
            이 메서드처럼 여러 스레드가 같은 메모리의 값을
            동시에 변경할 때 문제가 발생할 수 있는 코드를
            크리티컬 섹션이라 부른다
             */
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
                강남 서초 등 여러 개의 스레드가 같은 객체에 대해 메서드를 호출하여 동시에 값을 변경하려 할 때
                서로 그 메모리의 값을 덮어쓰는 문제가 발생한다
                이처럼 여러 스레드가 동시에 실행할 때 문제를 일으키는 코드를
                Critical section이라고 부른다
                여기 예제에서는 withdraw가 Critical section이다
                 */
            }
        }
    }
}