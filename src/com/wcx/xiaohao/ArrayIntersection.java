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

    public static void main(String[] args) {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int[] intersection = arrayIntersection.intersection(array1, array2);
        String s = ArrayUtils.arrayToString(intersection);
        System.out.println("打印： " + s);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println("第" + i + "个： " + intersection[i]);
        }
    }
}
