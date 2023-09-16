package com.java.oop;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        // 2、得到当前时间的毫秒值
        long time = d.getTime();
        System.out.println(time);

        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        LocalDateTime birthDate = LocalDateTime.of(1990, 10, 1, 10, 50, 30);
        System.out.println(birthDate);
        Duration duration = Duration.between(birthDate, today);
        //第二个参数减第一个参数
        System.out.println(duration.toDays());
        //两个时间差的天数
        System.out.println(duration.toHours());
        // 两个时间差的小时数
        System.out.println(duration.toMinutes());
        // 两个时间差的分钟数
        System.out.println(duration.toMillis());
        // 两个时间差的毫秒数
        System.out.println(duration.toNanos());
        // 两个时间差的纳秒数

    }
}
