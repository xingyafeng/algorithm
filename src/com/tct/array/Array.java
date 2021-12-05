package com.tct.array;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        System.out.println("print array ...");

        int[] arr = {1, 3, 4, 5, 5, 6, 9};
        for (int i = 0; i < arr.length; i++) System.out.println("i = " + i);
        System.out.println(Arrays.binarySearch(arr, 5));
        System.out.println(Arrays.toString(arr));
    }
}