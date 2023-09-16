package com.java.oop;

import java.util.Arrays;

public class LambdaDemo1 {

    public static void main(String[] args) {
//        goSwimming(() -> {
//            System.out.println("铁汁, 我们去游泳吧~");
//        });
//    }
//
//    public static void goSwimming(Swimming swimming) {
//        swimming.swim();

//        Integer ages = {66, 33, 22, 55, 88};
//        Arrays.sort(ages, (Integer o1, Integer o2) -> {
//            return o2 - o1;});
//        System.out.println("内容:" + Arrays.toString(ages));
        Integer[] ages = {66, 33, 22, 55, 88};
        Arrays.sort(ages, (Integer o1, Integer o2) -> o2 - o1);
        System.out.println("内容: " + Arrays.toString(ages));
    }
}