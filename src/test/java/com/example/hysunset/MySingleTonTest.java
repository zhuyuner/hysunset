package com.example.hysunset;

import com.example.hysunset.threadpool.MySingleton;
import java.util.*;
public class MySingleTonTest {

    public static void main(final String[] args) throws InterruptedException {
//        new Thread(() -> {
//            MySingleton instance = MySingleton.getInstance();
//            MySingleton.testIo(instance);
//        }, "t1").start();
//        new Thread(() -> {
//            MySingleton instance = MySingleton.getInstance();
//            MySingleton.testIo(instance);
//        }, "t2").start();
//
//        Thread.sleep(1000000);

        String appId = null;

        Map<String, String> data = new HashMap<>();
        data.put("appid", appId);
        data.put("mch_id", "");
        data.put("sub_mch_id", "aaa");
        data.put("nonce_str", UUID.randomUUID().toString());
        data.put("bill_date", "2023-09-28 00:00:00");
        data.put("bill_type", "ALL");
        data.put("sign_type", "MD5");

        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            if (data.get(k).trim().length() > 0) {// 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
            }
        }
    }


}


