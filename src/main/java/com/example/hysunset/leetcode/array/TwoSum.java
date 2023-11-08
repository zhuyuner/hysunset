package com.example.hysunset.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 01 两数之和
 *
 * @author zhy
 * @date 2023年5月21日 11:00
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0 || target == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] ints = {map.get(target - nums[i]), i};
                return ints;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    /**
     * 双指针算法
     *
     * @param nums
     * @param target
     * @return
     */

    static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 0 || target == 0) {
            return null;
        }
        int pre = 0;
        int tail = nums.length - 1;
        while (pre <= tail) {
            if (target - nums[pre] == nums[tail]) {
                int[] ans = {pre, tail};
                return ans;
            }
            tail--;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] ans = twoSum1(nums, target);
        System.out.println(ans);
    }

}
