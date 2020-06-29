package com.design.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //int[] arr = {9, 2, 3, 5, 7, 1, 4};
        //Cat[] arr = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Dog[] arr = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
