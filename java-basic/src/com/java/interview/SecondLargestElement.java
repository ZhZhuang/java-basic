package com.java.interview;

public class SecondLargestElement {


    public static void main(String[] args) {
        int[] arr = { 10, 5, 8, 20, 9, 25, 18 };
        int secondLargest = findSecondLarge(arr);

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("第二大的数是：" + secondLargest);
        } else {
            System.out.println("没有第二大的数。");
        }
    }

    public static int findSecondLarge(int[] a){
        int length = a.length;
        if(length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if(a[i]>max){
                second = max;
                max = a[i];
            }
            if(a[i]>second && a[i]<max)
                second = a[i];
        }
        return second;
    }
}
