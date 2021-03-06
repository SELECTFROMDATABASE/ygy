package com.gstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ Author     ：yangguangye.
 * @ Date       ：Created in 11:10 2019/3/4
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CmsConsoleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsConsoleApplication.class,args);
    }
}
