package com.osk2090.Test.G;

public class TTT {
    public static void main(String[] args) {
        GenericArrayList<Integer> intList = new GenericArrayList<>();
        GenericArrayList<String> stringList = new GenericArrayList<>();

        intList.add(1);
        intList.add(2);

        int intvalue1 = intList.get(0);
        int intvalue2 = intList.get(1);

        stringList.add("111");
        stringList.add("222");

        String stringvalue1 = stringList.get(0);
        String stringvalue2 = stringList.get(1);

        System.out.println(intvalue1);
        System.out.println(intvalue2);
        System.out.println(stringvalue1);
        System.out.println(stringvalue2);
    }
}