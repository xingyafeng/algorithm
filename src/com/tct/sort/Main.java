package com.tct.sort;

import com.tct.common.DateChecker;
import com.tct.common.Utils;

public class Main {

    public static void main(String[] args) {
//        int array[] = {2, 4, 5, 6, 1, 0, 9, 7, 3, 8,0,1,1,1};

//        int array[] = {1,4,7,8,3,6,9};
        int array[] = {1,4,2,6,8};

        Utils utils = new Utils();
        utils.printArray(array);
        System.out.println("-----====");

        // 1. 选中排序
//        utils.printArray(utils.SelectSort(array));

        // 2. 冒泡排序
//        utils.printArray(utils.BubblingSort(array));

        // 3. 插入排序
//        utils.printArray(utils.InsertSort(array));

        // 4、希尔排序
//        utils.printArray(utils.ShellSort(array));

        // 归并排序
        utils.MergeSort(array, 0,array.length-1);
//        utils.Merge(array,0,4,array.length-1);

        System.out.println("end ...");
        utils.printArray(array);

        System.out.println(DateChecker.check("ShellSort"));
//        System.out.println(getMax(array));
    }

    public static int getMax(int[] array) {
        return process(array, 0, array.length -1);
    }

    private static int process(int[] array, int L, int R) {
        if (L == R) {
            return array[R];
        }

        int mid = L + ((R-L) >> 1);
        int LeftMax  = process(array,0,mid);
        int RightMax = process(array,mid+1, R);

        return Math.max(LeftMax,RightMax);
    }

    public int sum(int[] array) {
        int sum = 0;
        return sum;
    }
}

