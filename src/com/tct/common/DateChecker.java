package com.tct.common;

import java.util.Arrays;
import java.util.Random;

public class DateChecker {

    static int[] generateRandomArray() {
        int[] array = new int[10000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }

        return array;
    }

    public static boolean check(String cs) {
        boolean is_same = true;

        int[] array_src = generateRandomArray();
        int[] array_dst = new int[array_src.length];
        System.arraycopy(array_src, 0, array_dst, 0, array_src.length);

        Utils utils = new Utils();

//        utils.printArray(array_src);
//        utils.printArray(array_dst);

        if (is_same == false)
            return false;

        Arrays.sort(array_src);

        switch (cs) {
            case "SelectSort":
                Utils.SelectSort(array_dst);
                break;

            case "BubblingSort":
                utils.BubblingSort(array_dst);
                break;
            case "InsertSort":
                utils.InsertSort(array_dst);
                break;
            case "ShellSort":
                utils.ShellSort(array_dst);
                break;
            case "MergeSort":
                utils.MergeSort(array_dst,0,array_dst.length-1);
                break;
            default:
                System.out.println("default not sort ...");
        }

//        utils.printArray(array_src);
//        utils.printArray(array_dst);

        for (int i = 0; i < array_src.length - 1; i++) {
            if (array_src[i] != array_dst[i]) {
                System.out.println("i = " + i + " ==> src = " + array_src[i] + "; dst = " + array_dst[i]);
                is_same = false;
            }
        }

        return is_same;
    }
}
