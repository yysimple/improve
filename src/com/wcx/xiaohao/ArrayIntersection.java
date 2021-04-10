package com.wcx.xiaohao;


import com.wcx.util.ArrayUtils;

/**
 * 项目: improve
 * <p>
 * 功能描述: 数组交集
 *
 * @author: WuChengXing
 * @create: 2021-04-09 11:03
 **/
public class ArrayIntersection {

    private static int[] array1 = new int[]{1, 3, 2, 4, 1};
    private static int[] array2 = new int[]{2, 4, 3};

    private static int[] array3 = new int[]{1, 2, 3, 4, 5};
    private static int[] array4 = new int[]{2, 3, 4};

    /**
     * 无序数据求交集
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] intersection(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int max = 0;
        int min = 0;
        int[] maxArray;
        int[] minArray;
        if (length1 <= length2) {
            max = length2;
            min = length1;
            maxArray = array2;
            minArray = array1;
        } else {
            max = length1;
            min = length2;
            maxArray = array1;
            minArray = array2;
        }
        int[] intersection = new int[max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < min; j++) {
                if (maxArray[i] == minArray[j]) {
                    intersection[i] = maxArray[i];
                }
            }
        }
        int arrSize = 0;
        for (int i = 0; i < intersection.length; i++) {
            if (intersection[i] != 0) {
                arrSize++;
            }
        }
        int[] newArray = new int[arrSize];

        for (int i = 0; i < intersection.length; i++) {
            if (intersection[i] != 0) {
                newArray[arrSize - i] = intersection[i];
            }
        }
        return newArray;
    }

    /**
     * 有序数组求交集
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] sortIntersection(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int max, min = 0;
        int[] maxArray;
        int[] minArray;
        if (length1 <= length2) {
            max = length2;
            min = length1;
            maxArray = array2;
            minArray = array1;
        } else {
            max = length1;
            min = length2;
            maxArray = array1;
            minArray = array2;
        }
        int[] intersection = new int[max];
        int i = 0, j = 0, k = 0;
        while (i < max && j < min) {
            if (maxArray[i] > minArray[j]) {
                j++;
            } else if (maxArray[i] < minArray[j]) {
                i++;
            } else {
                intersection[i] = maxArray[i];
                i++;
                j++;
            }
        }

        int arrSize = 0;
        for (int m = 0; m < intersection.length; m++) {
            if (intersection[m] != 0) {
                arrSize++;
            }
        }
        int[] newArray = new int[arrSize];

        for (int n = 0; n < intersection.length; n++) {
            if (intersection[n] != 0) {
                newArray[arrSize - n] = intersection[n];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int[] intersection = arrayIntersection.intersection(array1, array2);
        int[] sortIntersection = arrayIntersection.sortIntersection(array3, array4);
        String s1 = ArrayUtils.arrayToString(intersection);
        String s2 = ArrayUtils.arrayToString(sortIntersection);
        System.out.println("打印intersection： " + s1);
        System.out.println("打印sortIntersection： " + s2);
    }
}
