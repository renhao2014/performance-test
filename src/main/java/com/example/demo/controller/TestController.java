package com.example.demo.controller;

import com.example.demo.component.performance.AccessStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value ="")
    @ResponseBody
    public String test() throws InterruptedException {
        AccessStatistics.totalAccessIncerement();
        //模拟应用程序
        Thread.sleep(300);
        return "Server-A00-性能测试";
    }

}
