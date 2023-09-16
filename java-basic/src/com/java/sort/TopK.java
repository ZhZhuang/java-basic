package com.java.sort;



import java.util.ArrayList;
import java.util.Arrays;

// 方案1，基于排序的思想
public class TopK {
    public static void main(String[] args) {
        int[] sourceArray = {1, 2, 3, 4, 5};

        // 使用 Arrays.copyOf() 复制整个数组
        int[] copyOfWholeArray = Arrays.copyOf(sourceArray, sourceArray.length);

        // 使用 Arrays.copyOf() 复制数组的一部分
        int[] copyOfPartialArray = Arrays.copyOf(sourceArray, 3); // 复制前3个元素

        System.out.println("Original Array: " + Arrays.toString(sourceArray));
        System.out.println("Copy of Whole Array: " + Arrays.toString(copyOfWholeArray));
        System.out.println("Copy of Partial Array: " + Arrays.toString(copyOfPartialArray));
    }


    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        int n = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(n<k || n==0) return list;
        //排序
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        for(int i =0;i<k;i++)
        {
            list.add(input[i]);
        }

        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_2 (int[] input, int k) {
        int n = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(n<k || n==0) return list;

        Arrays.sort(input);
        for(int i =0;i<k;i++)
        {
            list.add(input[i]);
        }

        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_1(int [] input, int k) {
        int N=input.length;
        ArrayList<Integer> list=new ArrayList<>();
        if(k>N || N==0 ) return list;
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        for(int i=0;i<k;i++)
            list.add(input[i]);
        return list;
    }
}


// 方法2：改进快排
class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length < k){
            return list;
        }
        fastSort(input,0,input.length - 1);
        for(int i = 0;i < k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void fastSort(int[] array,int start,int tail) {
        if(start >= tail) {
            return;
        }
        //将第一个元素作为比较元素，从第二个开始到最后一个执行快速排序算法
        int begin = start;
        int end = tail;
        int key = array[start];
        while(begin < end) {
            while(array[end] >= key && begin < end) {
                end = end - 1;
            }
            while(array[begin] <= key && begin < end) {
                begin = begin + 1;
            }
            if(end > begin) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
        array[start] = array[begin];
        array[begin] = key;
        fastSort(array,start,begin - 1);
        fastSort(array,begin + 1,tail);
    }

}