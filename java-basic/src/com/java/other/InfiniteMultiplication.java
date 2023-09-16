package com.java.other;

// 同花顺 java笔试
// 乘法
public class InfiniteMultiplication {

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        // 将num1和num2中的字符转换为数字并执行乘法运算
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;

                // 更新结果数组
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // 将结果数组转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
//        String num1 = "1234567890123456789012345678901234567890";
//        String num2 = "9876543210987654321098765432109876543210";

        String num1 = "123";
        String num2 = "3";

        String result = multiply(num1, num2);

        System.out.println("结果：" + result);
    }
}
