package com.stephen.utils.bloom;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by stephen on 2021-03-12 11:34 .
 * Description: Guava的布隆过滤器实现
 */
public class GuavaBloomFilter {
    // 初始化容量
    private static int size = 100000000;

    // 设置误判率为0.001,默认是0.03
    private static BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),size,0.001);

    // private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size);

    public static void main(String[] args) {
        // 添加元素
        bloomFilter.put("aaa");
        // 判断是否存在
        System.out.println("bloomFilter.mightContain(\"aaa\") = " + bloomFilter.mightContain("aaa"));
        System.out.println("bloomFilter.mightContain(\"aab\") = " + bloomFilter.mightContain("aab"));
    }

}
