package com.java.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// 同花顺笔试
// 大整数加法
public class LargePositiveInteger {
    private List<Integer> digits;

    public LargePositiveInteger(String valueStr) {
        digits = new ArrayList<>();
        for (int i = valueStr.length() - 1; i >= 0; i--) {
            char digitChar = valueStr.charAt(i);
            if (Character.isDigit(digitChar)) {
                digits.add(Character.getNumericValue(digitChar));
            } else {
                throw new IllegalArgumentException("Input must contain only digits.");
            }
        }
    }

    public LargePositiveInteger add(LargePositiveInteger other) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        int maxLength = Math.max(digits.size(), other.digits.size());
        for (int i = 0; i < maxLength; i++) {
            int thisDigit = i < digits.size() ? digits.get(i) : 0;
            int otherDigit = i < other.digits.size() ? other.digits.get(i) : 0;

            int sum = thisDigit + otherDigit + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        LargePositiveInteger sum = new LargePositiveInteger("0");
        sum.digits = result;
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargePositiveInteger num1 = new LargePositiveInteger("123456789012345678901234567890");
        LargePositiveInteger num2 = new LargePositiveInteger("987654321098765432109876543210");

        LargePositiveInteger sumResult = num1.add(num2);
        System.out.println("Sum: " + sumResult);
    }
}
