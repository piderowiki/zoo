package com.ynu.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ZooApplication.class, args);
        new ZooServer(9999).run();
    }
}
