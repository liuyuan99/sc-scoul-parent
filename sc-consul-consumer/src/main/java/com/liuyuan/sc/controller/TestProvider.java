package com.liuyuan.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestProvider {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("service")
    public List<String> Service(){
        List<String> services = discoveryClient.getServices();
        return services;
    }


    @RequestMapping("getService")
    public List<ServiceInstance> getService(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");

        return provider;
    }

    @RequestMapping("bcall")
    public String balanceCall(){
        ServiceInstance providerName = loadBalancerClient.choose("providerName");
        String url = providerName.getUri().toString()+"/test";
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("return s is"+s);
        return s;
    }

    @RequestMapping("call")
    public String call(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        if(provider!=null && provider.size()>0){
            RestTemplate restTemplate = new RestTemplate();
            ServiceInstance serviceInstance = provider.get(0);
            String forObject = restTemplate.getForObject(serviceInstance.getUri().toString() + "/test", String.class);

            return forObject;
        }
        return "no service";
    }
}
