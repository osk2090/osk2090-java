package com.osk2090.Exception.ex3;

import java.util.Scanner;

public class Exam0620 {
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(System.in);

            System.out.println("입력>");
            int value = scan.nextInt();
            System.out.println(value * value);
        }finally {
            scan.close();
            System.out.println("스캐너 자원 해제");
        }
    }
}