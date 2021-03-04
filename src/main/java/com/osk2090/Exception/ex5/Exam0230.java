package com.osk2090.Exception.ex5;

import java.util.Scanner;

public class Exam0230 {
    static Client read() throws ClientException {
        try (Scanner scan = new Scanner(System.in)) {
            Client client = new Client();

            System.out.println("번호:");
            client.setNo(scan.nextInt());
            scan.nextLine();

            System.out.println("이름:");
            client.setName(scan.nextLine());

            System.out.println("나이:");
            client.setAge(scan.nextInt());

            return client;
        } catch (Exception 원본오류) {
            throw new ClientException("회원 입력 도중 오류 발생", 원본오류);
        }
    }

    public static void main(String[] args) {
        try {
            Client client = read();
            System.out.println("------------------------");
            System.out.printf("번호: %d\n", client.getNo());
            System.out.printf("이름: %s\n", client.getName());
            System.out.printf("나이: %d\n", client.getAge());
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}