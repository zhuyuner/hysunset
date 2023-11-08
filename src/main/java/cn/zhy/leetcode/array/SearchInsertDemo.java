package cn.zhy.leetcode.array;

/**
 * 35. 搜索插入位置
 *
 * @author zhy
 * @date 2023年5月23日
 */
public class SearchInsertDemo {

    static int search(int[] nums, int target) {
        if (nums.length == 0 || target == 0) {
            return 0;
        }
        int pre = 0;
        int tail = nums.length - 1;
        while (pre <= tail) {
            if (nums[pre] == target && nums[tail] == target) {
                return pre;
            }
            if (nums[pre] == nums[tail]) {
                return pre + 1;
            }
            if (nums[pre] == target) {
                return pre;
            }
            if (nums[pre] < target && nums[pre + 1] > target) {
                return pre + 1;
            }
            if (nums[tail] < target) {
                return tail + 1;
            }
            if (nums[tail] == target) {
                return tail;
            }
            pre++;
            tail--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        System.out.println(search(nums, target));
    }

}
