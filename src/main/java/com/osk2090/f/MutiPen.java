package com.osk2090.f;

public class MutiPen extends Zebra implements Pen {
    @Override
    public void write(String text) {
        if (!this.use) {
            return;
        }
        System.out.println("지브라>> " + text);
    }
}