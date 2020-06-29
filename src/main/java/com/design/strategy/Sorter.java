package com.design.strategy;

//排序
public class Sorter {

    //选择排序
    public static void sort(Comparable[] ary) {
        for (int i = 0; i < ary.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < ary.length; j++) {
                minPos = ary[j].compareTo(ary[minPos]) == -1 ? j : minPos;
            }
            swap(ary, i, minPos);
        }
    }

    static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
