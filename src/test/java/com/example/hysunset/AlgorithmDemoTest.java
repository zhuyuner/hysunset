package com.example.hysunset;

import com.example.hysunset.leetcode.array.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.util.Random;

@SpringBootTest
public class AlgorithmDemoTest {

    @Resource
    BinarySearch binarySearch;

    void swap(int[] array) {
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
    }

    @Test
    public void htSwap() {
        int[] array = {2, 4, 5, 6, 8, 9, 1, 2};
        swap(array);
        Assertions.assertArrayEquals(new int[]{2, 1, 9, 8, 6, 5, 4, 2}, array);
    }

    void htHandSwap(int[] array) {
        if (array == null) {
            return;
        }
        for(int s=0,e=array.length-1;s<e;s++,e--)  {
            int temp = array[s];
            array[s] = array[e];
            array[e] = temp;
        }
    }

    /**
     * 双指针交换数组首尾位置
     */
    @Test
    public void htHandSwap() {
        int[] array = {2, 4, 5, 6, 8, 9, 1, 2};
        htHandSwap(array);
        Assertions.assertArrayEquals(new int[]{2, 1, 9, 8, 6, 5, 4, 2}, array);
    }

    @Test
    public void binarySearch(){
        int[] array = {4, 6, 3, 8, 2, 9, 1};
       System.out.println( binarySearch.binarySearch(array,2));
    }

    @Test
    public void towaccountItem (){

        Random random = new Random();
//        for(int i = 0 ; i<1000; i++){
//            int value = random.nextInt(100);
//            System.out.println("value:" +value);
//        }

        int randIndex = random.nextInt(2);
        System.out.println("value:" +randIndex);


    }




}
