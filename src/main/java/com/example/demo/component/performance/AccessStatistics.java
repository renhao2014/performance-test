package com.example.demo.component.performance;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 访问量统计数据
 */
public class AccessStatistics {
    private static Integer totalAccess=0;
    private static Integer lastStageTotalAccess=0;

    private static HashMap<String,Integer> statistics=new HashMap<>();

    /**
     * 多线程变量,需要加锁
     */
    private static ReentrantLock reentrantLock =new ReentrantLock();

    public static Integer getTotalAccess(){
        return totalAccess;
    }

    public static void totalAccessIncerement(){
        reentrantLock.lock();
        totalAccess++;
        reentrantLock.unlock();
    }

    public static void setLastStageTotalAccess(Integer lastStageTotalAccessParam){
        reentrantLock.lock();
        lastStageTotalAccess=lastStageTotalAccessParam;
        reentrantLock.unlock();
    }

    public static Integer calculateAccessCurrentStage(){
        reentrantLock.lock();
        Integer count=totalAccess-lastStageTotalAccess;
        lastStageTotalAccess=totalAccess;
        reentrantLock.unlock();
        return count;
    }


}
