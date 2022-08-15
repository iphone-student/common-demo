package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zaf
 * @date 2021/7/27 14:43 上午
 * @description
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class UserManagerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerServerApplication.class, args);
        System.out.println("----swagger  http://localhost:9001/doc.html");

    }
}
