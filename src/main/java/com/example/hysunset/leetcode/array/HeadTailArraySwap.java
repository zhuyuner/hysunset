package com.example.hysunset.leetcode.array;

import org.springframework.stereotype.Service;

/**
 * 首位替换，中间为基准进行替换
 *
 * @author zhy
 * @date 2023年3月1日
 */

@Service
public class HeadTailArraySwap {
    public int[] swap(int[] array) {
        int base = array.length / 2;
        for (int i = 1; i <= base; i++) {
            int temp = array[base - i];
            int left = base - i;
            int right = base + i;
            if (base % 2 == 0) {
                array[left] = array[right - 1];
                array[right - 1] = temp;
            } else {
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }

    public int[] htHandSwap(int[] array, int head, int tail) {
        while (head <= tail) {
            int temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
            head++;
            tail--;
        }
        return array;
    }
}
