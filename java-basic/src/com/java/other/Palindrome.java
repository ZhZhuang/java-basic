package com.java.other;

// 判断回文
// 回文就是正着，反着都一样
// 回文的问题较多！！！！！！
public class Palindrome {



    //判断字符串是否为回文串（字母忽略大小写，忽略字母和数字以外的字符）
    public static void main(String[] args) {
        String inputString = "A man, a plan, a canal, Panama!";
        System.out.println(isPalindrome(inputString)); // 输出: true

    }


    public static boolean isPalindrome(String s) {
        // 将字符串转换为小写，并去除非字母数字字符
        String cleanedS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedS.length() - 1;

        while (left < right) {
            if (cleanedS.charAt(left) != cleanedS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // 是否是回文
    public boolean palindrome(String s) {
        if(s== null)
            return false;
        if(s.length() == 1)
            return true;
        int low = 0;
        int high = s.length() - 1;
        for(;low<high;low++,high--){
            if(s.charAt(low) != s.charAt(high))
                return false;
        }
        return true;
    }

    //给定一个字符串，编写一个函数判定其是否为某个回文串的排列  之一 。

}
