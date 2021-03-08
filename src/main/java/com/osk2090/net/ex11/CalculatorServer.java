package com.osk2090.net.ex11;

import java.net.ServerSocket;

public class CalculatorServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(8888)) {
            System.out.println("서버 실행중...");
            while (true) {
                /*
                클라이언트가 접속하면
                각 클라이언트이 요청을 main 실행에서 분리하여 별도로 실행해야 하기 때문에
                각 클라이언트에 대해 Thread 객체를 따로 만들어 실행한다
                그래서 이전처럼 한 객체를 사용할 수 없다
                 */

                RequestProcessor thread = new RequestProcessor(ss.accept());

                //run() 메서드를 직접 호출하면 안된다
                //스레드에게 독립적으로 실핼하라고 명령해야 한다
                thread.start();
                /*
                start() 메서드는 main 실행과 분리하여 별도의 실행 모드에서 run()을 호출한다
                그런 후 run() 메서드가 리턴할 때까지 기다리지 않고 즉시 리턴한다
                따라서 기존 클라이언트의 요청을 처리하는데 시간이 걸리더라도
                다른 클라이언트는 영향을 받지 않는다
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}