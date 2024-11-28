package com.solohouse.boxes.bootstrap;

import com.solohouse.boxes.SpringAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.solohouse.boxes")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppConfig.class, args);
    }

}