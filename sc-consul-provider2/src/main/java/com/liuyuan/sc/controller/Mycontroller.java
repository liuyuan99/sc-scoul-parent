package com.liuyuan.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @RequestMapping("test")
    public String test(){
        return "this is test2222222    ";
    }
}
