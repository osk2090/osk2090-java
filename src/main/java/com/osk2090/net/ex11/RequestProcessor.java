package com.osk2090.net.ex11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestProcessor extends Thread {
    Socket socket;

    public RequestProcessor(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        /*
        이 메소드는 한 번 호출되면 재호출될 수 없다
        따라서 한 스레드당 한번만 호출될 수 있다

        main 실행과 분리하여 독립적으로 실행할 코드가 있다면 이 메서드 안에 둔다
        */
        try (Socket socket = this.socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream out = new PrintStream(socket.getOutputStream())) {

            //웹브라우저가 보낸 첫 줄에는 데이터가 포함되어 있기 때문에 따로 추출한다
            String requestLine = in.readLine();
            while (true) {
                if (in.readLine().length() == 0) {
                    break;
                }
            }
            sendHttpResponse(out, compute(requestLine));

        } catch (Exception e) {
            System.out.printf("클라이언트 요청 처리 중 오류 발생! - %s\n", e.getMessage());
        }
    }

    //연산을 담당하는 메서드
    private String compute(String request) {
        try {
            //웹브라우저가 보낸 request line에서 데이터를 추출한다
            //    예) "GET /plus?a=100&b=200 HTTP/1.1"
            String[] values = request.split(" ")[1].split("\\?");//스페이스로 나눠서 배열로 저장한다

            String op = getOperator(values[0]);

            String[] parameters = values[1].split("&");
            int a = 0;
            int b = 0;

            for (String parameter : parameters) {
                String[] kv = parameter.split("=");
                if (kv[0].equals("a")) {
                    a = Integer.parseInt(kv[1]);
                } else if (kv[0].equals("b")) {
                    b = Integer.parseInt(kv[1]);
                }
            }

            int result = 0;

            switch (op) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    return "해당 연산자를 지원하지 않습니다.";
            }
            return String.format("결과는 %d %s %d = %d 입니다.", a, op, b, result);
        } catch (Exception e) {//예외처리
            return String.format("계산 중 오류 발생! - %s", e.getMessage());
        }
    }

    private String getOperator(String name) {
        switch (name) {
            case "/plus":
                return "+";
            case "/minus":
                return "-";
            case "/multiple":
                return "*";
            case "/devide":
                return "/";
            default:
                return "?";
        }
    }

    private void sendHttpResponse(PrintStream out, String message) throws Exception {
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain;charset=UTF-8");
        out.println();
        out.println(message);
        out.flush();
    }
}