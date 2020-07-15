package com.liuyuan.sc.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString  //生成tostring方法
//@AllArgsConstructor   //生成全参构造方法
@ConfigurationProperties(prefix = "myconfig")
public class MyConfig {

    private String name;

    private int age;

    private String gender;

    private String icard;


    //@AllArgsConstructor就相当于这个
//    public MyConfig(String name, int age, String gender, String idcard) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.idcard = idcard;等会我弟在我变

//    }

}
