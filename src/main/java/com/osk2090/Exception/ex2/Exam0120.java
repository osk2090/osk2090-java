package com.osk2090.Exception.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam0120 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("입력>");
            String op = scan.next();
            if (op.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                int v1 = scan.nextInt();
                int v2 = scan.nextInt();

                int result = Calculator3.compute(op, v1, v2);
                System.out.println(result);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("입력한 값이 유효하지 않습니다.");
                scan.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }
}