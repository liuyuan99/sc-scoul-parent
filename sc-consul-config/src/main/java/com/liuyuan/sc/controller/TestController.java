package com.liuyuan.sc.controller;

import com.liuyuan.sc.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${myNameKey:xiyangyang}")
    private String myName;

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("testkey")
    public String test(){

        return myName;
    }


    @RequestMapping("myconfig")
    public MyConfig myconfig(){

        return myConfig;
    }


}
