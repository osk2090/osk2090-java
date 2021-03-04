package com.osk2090;

class D {
    int v1 = 1;

    void m1() {
        int v2 = 2;

        class X {
            int v3 = 3;

            void f() {
                int v4 = 4;
                System.out.printf("v4 = %d\n", v4);
                System.out.printf("v3 = %d\n", this.v3);
                System.out.printf("v2 = %d\n", v2);
                System.out.printf("v1 = %d\n", D.this.v1);

            }
        }

        X x = new X();
        x.f();

    }
}

public class local {
    public static void main(String[] args) {
        D d = new D();
        d.m1();
    }
}