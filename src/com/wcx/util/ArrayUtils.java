package com.wcx.util;

/**
 * 项目: improve
 * <p>
 * 功能描述: 数组工具类
 *
 * @author: WuChengXing
 * @create: 2021-04-09 12:06
 **/
public class ArrayUtils {

    public static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (array.length < 1) {
            stringBuilder.append("]");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i != array.length - 1) {
                    stringBuilder.append(array[i] + ",");
                } else {
                    stringBuilder.append(array[i]);
                }
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
