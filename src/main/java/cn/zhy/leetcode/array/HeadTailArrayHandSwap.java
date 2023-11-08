package cn.zhy.leetcode.array;

import org.springframework.stereotype.Service;

/**
 * 首位替换——双指针算法
 *
 * @author zhy
 * @date 2023年3月1日
 */

@Service
public class HeadTailArrayHandSwap {

    public int[] swap(int[] array,int head,int tail) {
        while (head <= tail){
            int temp = array[head++];
            array[head++] = array[tail--];
            array[tail--] = temp;

        }
        return array;
    }
}
