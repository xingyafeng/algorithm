package com.tct.common;

public class Utils {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 插入排序，思路：
     * 拿数组中的每一个数与后面的所有数进行对比取最小值，然后最交换。
     * <p>
     * 优化思路：
     * 拿出数组的每一个数以后面比较的时候，找出一个最大和最小，最小放前面，最大放最后。
     * <p>
     * big O 分析：
     * 一、时间复杂度
     * 1、初始化 不计入算法时间
     * 2、 一个 for 中  i=0 ； i< arrary.lenght -1； i++；minPos =i   (执行n次)
     * 3、 第二个for 执行 (n-1) + (n-2) + (n-3) ... 1 = 等差和 n*(n-1)/2 = n^2/2
     * n^2/2 + n/2 + T  忽略后 n^2 O
     * 结果：(n^2)
     * <p>
     * 二、空间复杂度 （分配额外的空间） 使用其他容器来做备份
     * 结果 O(1)
     * <p>
     * 三、不稳定
     * 什么叫不稳定？ 对于 相等的两个数，可能后排到后面去。
     * <p>
     * 一个标记最小值得位置参数
     *
     * @param array
     * @return
     */
    public static int[] SelectSort(int[] array) {
        System.out.println("lenght = " + array.length);
        for (int i = 0, k = array.length - 1; i < array.length - 1 && k > 0; i++, k--) {
            int minPos = i;
            int maxPos = k;

            // 注意数组越界，j 有加一的问题，故条件不用减一
            for (int j = i + 1; j < array.length; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
            }

            Utils.swap(array, i, minPos);

            for (int j = k; j > 0; j--) {
                maxPos = array[j] > array[maxPos] ? j : maxPos;
            }

            Utils.swap(array, k, maxPos);
        }

        return array;
    }

    /**
     * 冒泡排序 ---- 思路：
     * 从头开始两两交互，大的放前面，小的放后面
     * 注意： 完成一次排序，就少一次，因为最大的已经找到。
     * 时间复杂度 O(N^2) 最好情况 O(N) 最好情况如何实现？？
     * 空间复杂度 O(1)
     *
     * @param array
     * @return
     */
    public int[] BubblingSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    Utils.swap(array, j, j + 1);
                }
            }
        }

        return array;
    }

    /**
     * 插入排序： 思路
     * 保证0~i 的依次有顺序，从第二位数开始依次与前面的数进行比较，若小于前面的数则交换
     * 与冒泡相似，倒着的冒泡。
     * <p>
     * 去掉sawp方法， 用一个临时变量，一个一个挪动
     * <p>
     * 总结：
     * 冒泡： 慢
     * 选中，不稳定
     * 插入: 快而且稳定
     *
     * @param array
     * @return
     */
    public int[] InsertSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) { // 保证0~i 有序
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                }
//                new Utils().printArray(array);
            }
        }
//        System.out.println("end ...");
        return array;
    }

    public int[] ShellSort(int[] array) {
        for (int gap = 4; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (array[j] < array[j - gap]) {
                        swap(array, j - gap, j);
                    }
//            new Utils().printArray(array);
                }
            }
        }

//        System.out.println("\nend ...");
        return array;
    }

    public void MergeSort(int[] array, int left, int right) {
        if (left == right) return;

        // 分成两半
        int mid = left + (right - left) / 2;

        //左半边排序
        MergeSort(array, left, mid);
        //右半边排序
        MergeSort(array, mid + 1, right);

        System.out.print("new ===> ");
        Utils.printArray(array);
        //归并
        Merge(array, left, mid + 1, right);
        System.out.print("end ===> ");
    }

    public void Merge(int[] array, int leftPtr, int rightPtr, int rightBound) {

        int mid = rightPtr - 1;
        int[] tmp = new int[rightBound - leftPtr + 1];

        // 左指针
        int i = leftPtr;
        // 右指针
        int j = rightPtr;
        // 临时tmp指针
        int k = 0;

        while (i < mid && j <= rightBound) {
            if (array[i] <= array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }

        while (i <= mid) tmp[k++] = array[i++];
        while (j <= rightBound) tmp[k++] = array[j++];

//        printArray(tmp);

        for (int m = 0; m < tmp.length - 1; m++) {
            array[m] = tmp[m];
        }
//        printArray(tmp);
//        printArray(array);
    }
}
