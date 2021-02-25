package com.stephen.utils.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by stephen on 2021-02-25 16:15 .
 * Description: TreeMap默认按照key值升序排列
 * 如果想倒序排列，可自定义一个Comparator，在返回值前加一个负号,就以相反的顺序输出
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>(new MyComparator());
        map.put("a", "a");
        map.put("s", "b");
        map.put("f", "f");
        map.put("d", "d");
        map.put("c", "c");
        map.put("g", "g");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
            System.out.println("==================");
        }

    }

}

class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String param1 = (String)o1;
        String param2 = (String)o2;
        return -param1.compareTo(param2);
    }
}