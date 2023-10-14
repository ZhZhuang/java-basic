package com.java.DesignPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star createProxy(BigStar bigStar){
        Star starProxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override       // 这是一个回调方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("sing"))
                            System.out.println("准备话筒，收费");
                        else if(method.getName().equals("dance"))
                            System.out.println("准备舞台，收费");
                        return method.invoke(bigStar,args);
                    }
                }
        );
        return starProxy;
    }
}
