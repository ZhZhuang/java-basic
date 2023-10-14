package com.java.DesignPattern.dynamicProxy;

public class Test {
    public static void main(String[] args) {
        BigStar s = new BigStar("杨超越");

        Star proxStar = ProxyUtil.createProxy(s);

        String res = proxStar.sing("好日子");
        System.out.println(res);

        proxStar.dance();

    }
}
