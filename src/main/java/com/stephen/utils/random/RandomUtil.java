package com.stephen.utils.random;

import java.util.Random;

/**
 * Created by stephen on 2021-04-06 9:57 .
 * Description: 生成固定位数的随机字符
 */
public class RandomUtil {

    public static void main(String[] args) {
        System.out.println(generateRandomStr(10));
    }

    public static String generateRandomStr(int n) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789`~!@#$%^&*()_+-=".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(chars[new Random().nextInt(chars.length)]);
        }
        return sb.toString();
    }

}
