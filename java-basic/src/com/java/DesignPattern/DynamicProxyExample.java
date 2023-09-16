package com.java.DesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 创建一个接口，表示要代理的服务
interface Calculator {
    int add(int a, int b);
}


// 创建一个实际的服务类
class CalculatorImpl implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// 创建一个日志记录的代理处理器
class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("Method " + method.getName() + " returned: " + result);
        return result;
    }
}


public class DynamicProxyExample {
    public static void main(String[] args) {
        Calculator realCalculator = new CalculatorImpl();

        // 创建动态代理
        Calculator proxyCalculator = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},
                new LoggingHandler(realCalculator)
        );

        // 调用代理对象的方法
        int result = proxyCalculator.add(2, 3);
        System.out.println("Result: " + result);
    }
}
