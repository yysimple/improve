package com.wcx.leetcode;

import com.wcx.util.ArrayUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目: improve
 * <p>
 * 功能描述: 两数之和
 *
 * @author: WuChengXing
 * @create: 2021-04-10 09:28
 **/
public class SumOfTwoNum {

    // [3, 3]
//     private static int[] arr1 = new int[]{3, 3};
    // [2,7,11,15]
    private static int[] arr1 = new int[]{2, 7, 11, 15};

    public static void main(String[] args) {
        SumOfTwoNum sumOfTwoNum = new SumOfTwoNum();
       /* long startTime = System.currentTimeMillis();
        int[] twoIndex = sumOfTwoNum.getTwoIndex(arr1, 9);
        String s = ArrayUtils.arrayToString(twoIndex);
        System.out.println("打印： " + s);
        long endTime = System.currentTimeMillis();
        long timeConsuming = endTime - startTime;
        System.out.println("耗时：" + timeConsuming + "ms");*/


        long startTime = System.currentTimeMillis();
        int[] twoIndexMap = sumOfTwoNum.getTwoIndexMap(arr1, 9);
        String s1 = ArrayUtils.arrayToString(twoIndexMap);
        System.out.println("打印twoIndexMap ： " + s1);
        long endTime = System.currentTimeMillis();
        long timeConsuming = endTime - startTime;
        System.out.println("耗时：" + timeConsuming + "ms");


    }

    /**
     * 功能描述: 通过两轮数据遍历，效率低。类似冒泡排序
     *
     * @param arr1
     * @param target
     * @return int[]
     * @author WuChengxing
     * @date 2021/4/10
     */
    public int[] getTwoIndex(int[] arr1, int target) {
        int[] newArr = new int[2];
        int length = arr1.length;
        int i = 0;
        while (i < length) {
            int k = i + 1;
            for (; k < length; k++) {
                if ((arr1[i] + arr1[k]) == target) {
                    newArr[0] = i;
                    newArr[1] = k;
                }
            }
            i++;
        }
        return newArr;
    }

    /**
     * 功能描述: 通过map的形式去获取key的方式，效率更高
     *
     * @param temp
     * @param target
     * @return int[]
     * @author WuChengxing
     * @date 2021/4/10
     */
    public int[] getTwoIndexMap(int[] temp, int target) {
        Map<Integer, Integer> map = new ConcurrentHashMap(2);
        for (int i = 0; i < temp.length; i++) {
            int t1 = target - temp[i];
            if (map.containsKey(t1)) {
                return new int[]{i, map.get(t1)};
            }
            map.put(temp[i], i);
        }
        return null;
    }
}
