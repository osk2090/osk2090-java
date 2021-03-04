package com.osk2090.f;

public class Exam01 {
    public static void main(String[] args) {
        BallPen153 t1 = new BallPen153();
        MutiPen t2 = new MutiPen();

        Canvas c1 = new Canvas(t1);

        t1.press(false);
        c1.render("펜으로 그린 그림");
        c1.setPen(t2);
        t2.rotate(Zebra.ON);
        c1.render("펜으로 그린 그림");
    }
}