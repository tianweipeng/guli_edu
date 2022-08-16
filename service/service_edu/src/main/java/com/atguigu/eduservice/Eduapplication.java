package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
public class Eduapplication {
    public static void main(String[] args) {
        SpringApplication.run(Eduapplication.class, args);
    }
}
