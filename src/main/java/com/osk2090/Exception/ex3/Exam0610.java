package com.osk2090.Exception.ex3;

import java.util.Scanner;

public class Exam0610 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력>");
        int value = scan.nextInt();

        System.out.println(value * value);

        scan.close();//자원해제
    }
}