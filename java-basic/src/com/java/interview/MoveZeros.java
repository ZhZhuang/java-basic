package com.java.interview;


import java.util.Arrays;

// 有一个非空的乱序数组，其中有若干个0。请将所有的0，移动到数组末尾。
public class MoveZeros {

    // 秒 ！！！！！
    // GPT 的思想，记录非0的数量，思想很是巧妙
    public static void moveZeros(int[] nums) {
        int n = nums.length;
        int nonZeroIdx = 0;

        // 将非零元素移到数组前面
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIdx++] = nums[i];
            }
        }

        // 填充数组末尾的零
        while (nonZeroIdx < n) {
            nums[nonZeroIdx++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
