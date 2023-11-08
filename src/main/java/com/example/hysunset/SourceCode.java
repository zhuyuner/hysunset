package com.example.hysunset;

import java.util.HashMap;

public class SourceCode {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 韦哥 —> 取得2的次幂
     *
     * @param cap
     * @return
     */
    static final int tableSizeFo1r(int cap) {
        int size = 1;
        while (size < cap && size < MAXIMUM_CAPACITY) {
            size = size << 1;
        }
        return size;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void main(String[] args) {
        System.out.println("最大容量：" + MAXIMUM_CAPACITY);
        System.out.println(tableSizeFo1r(6));
        HashMap<String, String> map = new HashMap<>(8, 1.0f);
        map.put("zhy", "122");
        System.out.println(hash("zhy"));


    }
}
