package com.lshh.boardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BoardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardServerApplication.class, args);
    }

}
