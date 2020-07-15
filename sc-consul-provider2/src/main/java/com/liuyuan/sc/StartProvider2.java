package com.liuyuan.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StartProvider2 {
    public static void main(String[] args) {
        System.out.println("注册启动");
        SpringApplication.run(StartProvider2.class);
    }
}
