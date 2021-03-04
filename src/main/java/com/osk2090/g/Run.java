package com.osk2090.g;

public class Run {
    public static void main(String[] args) {
        Ferrari ferrari = new Ferrari("엔초페라리", 5998);
        ferrari.on();
        ferrari.run();
        ferrari.off();
        System.out.println("--------------------------------");

        Sonata sonata = new Sonata("NF소나타", 1598);
        sonata.on();
        sonata.run();
        sonata.off();
        System.out.println("--------------------------------");

        Truck truck = new Truck("볼보트럭", 12100);
        truck.on();
        truck.run();
        truck.off();
    }
}