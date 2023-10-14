package com.java.DesignPattern.dynamicProxy;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + ":" + name);
        return "谢谢，唱完了！";
    }

    @Override
    public void dance() {
        System.out.println(this.name + ":" + "正在跳舞");
    }
}
