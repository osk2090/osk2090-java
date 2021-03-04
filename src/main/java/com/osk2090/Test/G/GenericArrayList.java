package com.osk2090.Test.G;

public class GenericArrayList<T> {
    private Object[] elementData = new Object[5];
    private int size;

    public void add(T value) {
        elementData[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int idx) {
        return (T) elementData[idx];
    }
}