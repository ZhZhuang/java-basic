package com.java.grammar;
import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i_score;
        System.out.print("请输入分数=");
        i_score = scan.nextInt(); // 输入一个整数
        i_score /= 10; //得到原始分数所处的分数段
        switch(i_score)
        {
            case 10: //[90, 100]范围内的分值都属于优秀级别
            case 9:
                System.out.println("成绩为优秀!");
                break;
            case 8:
                System.out.println("成绩为良好!");
                break;
            case 7:
                System.out.println("成绩为中等!");
                break;
            case 6:
                System.out.println("成绩为及格!");
                break;
            default:
                System.out.println("成绩为不及格!");
        }
    }
}
