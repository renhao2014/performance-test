package com.example.demo.component.performance;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class PerformanceTimer implements Runnable{

    @Override
    public void run() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前时间:"+new Date());
                //
                System.out.println("总请求次数"+AccessStatistics.getTotalAccess()+" 阶段请求次数:"+AccessStatistics.calculateAccessCurrentStage()/2);
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
