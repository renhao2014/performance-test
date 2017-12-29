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
    public String test(){
        AccessStatistics.totalAccessIncerement();
        return "Server-A04-性能测试";
    }

}
