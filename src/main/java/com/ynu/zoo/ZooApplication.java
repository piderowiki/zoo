package com.ynu.zoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ynu.zoo.mapper")
public class ZooApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ZooApplication.class, args);
        new ZooServer(9999).run();
    }
}
