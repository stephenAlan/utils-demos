package com.stephen.utils.bloom;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by stephen on 2021-03-12 10:56 .
 * Description: 布隆过滤器
 *  当 isContain() 返回false时，元素一定不存在，当返回true时，元素不一定存在
 */
public class MyBloomFilter {
    // 布隆过滤器 容量
    private static final int DEFAULT_SIZE = 2 << 28;

    // bit数组,用来存放key
    private static BitSet bitSet = new BitSet(DEFAULT_SIZE);

    // 后面的hash函数会用到,用来生成不同的hash值,可随意设置
    private static final int[] ints = {1,2,3,4,5,6};

    // 添加元素,计算出key的hash值,并将对应下标设为1
    public void add(Object key) {
        Arrays.stream(ints).forEach(i -> bitSet.set(hash(key,i)));
    }

    // 判断是否存在,当返回false时,一定不存在
    public boolean isContain(Object key) {
        boolean result = true;
        for (int i : ints) {
            // 只要有一个bit位为0,则返回false
            result = result && bitSet.get(hash(key,i));
        }
        return result;
    }

    // hash函数,借鉴hashmap的扰动算法
    private int hash(Object key,int i) {
        int h;
        return key == null ? 0 : (i * (DEFAULT_SIZE - 1) & ((h = key.hashCode()) ^ (h >>> 16)));
    }


    public static void main(String[] args) {
        MyBloomFilter filter = new MyBloomFilter();
        filter.add("张三");
        filter.add("李四");
        filter.add("111");
        filter.add("abc ");

        System.out.println("filter.isContain(\"张三\") = " + filter.isContain("张三"));
        System.out.println("filter.isContain(\"李四\") = " + filter.isContain("李四"));
        System.out.println("filter.isContain(\"111\") = " + filter.isContain("111"));
        System.out.println("filter.isContain(\"abc\") = " + filter.isContain("abc"));
        System.out.println("filter.isContain(\"abc \") = " + filter.isContain("abc "));
        System.out.println("filter.isContain(\"222\") = " + filter.isContain("222"));
    }

}
