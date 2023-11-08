package cn.zhy.leetcode.array;

import org.springframework.stereotype.Service;

/**
 * 二分查找算法
 *
 * @author zhy
 * @date 2023年3月2日
 */
@Service
public class BinarySearch {

    public int binarySearch(int[] srcArray,  int des) {
        if (srcArray == null ) {
            return 0;
        }
        int mid = srcArray.length/2;
        if(des== srcArray[mid]){
           return srcArray[mid];
        }
        if(des< srcArray[mid]){
            mid =mid/2;
            if(mid==srcArray[mid]){
                return srcArray[mid];
            }
        }
        if(des > srcArray[mid]){

        }
        return 0;
    }
}
