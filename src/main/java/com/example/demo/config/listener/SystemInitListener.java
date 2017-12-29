package com.example.demo.config.listener;

import com.example.demo.component.performance.PerformanceTimer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebListener
public class SystemInitListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("系统初始化");
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new PerformanceTimer());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
