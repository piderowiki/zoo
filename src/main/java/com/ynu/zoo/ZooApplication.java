package com.ynu.zoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@MapperScan("com.ynu.zoo.mapper")
public class ZooApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(ZooApplication.class, args);
        ZooServer zooServer = ctx.getBean("ZooServer",ZooServer.class);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(zooServer);
        service.shutdown();
    }
}
