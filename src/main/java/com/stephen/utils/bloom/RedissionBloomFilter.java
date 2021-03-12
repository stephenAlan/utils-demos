package com.stephen.utils.bloom;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Created by stephen on 2021-03-12 11:54 .
 * Description: redisson实现布隆过滤器
 */
public class RedissionBloomFilter {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("localhost:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("redisBloomFilter");
        // 初始化布隆过滤器,预计元素为10000000L,误判率为0.03(google的默认值)
        bloomFilter.tryInit(10000000L,0.03);
        // 插入数据到
        bloomFilter.add("hello");
        bloomFilter.add("111");
        // 判断是否存在
        System.out.println("bloomFilter.contains(\"hello\") = " + bloomFilter.contains("hello"));
        System.out.println("bloomFilter.contains(\"hello \") = " + bloomFilter.contains("hello "));
        System.out.println("bloomFilter.contains(\"111\") = " + bloomFilter.contains("111"));
        System.out.println("bloomFilter.contains(\"112 \") = " + bloomFilter.contains("112"));


    }

}
