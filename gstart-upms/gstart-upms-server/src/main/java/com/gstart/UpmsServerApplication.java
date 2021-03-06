package com.gstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yangguangye
 * @Create by gzpykj
 * @Date 2019-03-03 15:23
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UpmsServerApplication implements BaseApplication{
    public static void main(String[] args) {
        SpringApplication.run(UpmsServerApplication.class,args);
    }
}
