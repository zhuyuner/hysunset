package com.example.hysunset;

public class StackOverflowTest {
    static int count = 0;
    static void redo(){
        count++;
        redo();
    }
    public static void main(String[] args){
        try {
            redo();
        } catch (Exception e) {
            System.out.println(count);
        }

    }
}
