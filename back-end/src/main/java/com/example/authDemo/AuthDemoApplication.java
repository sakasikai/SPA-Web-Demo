package com.example.authDemo;

import com.example.authDemo.controller.Auth.LoginController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses={LoginController.class},
        basePackages={"com.example.authDemo.mapper",
                       "com.example.authDemo.model",
                        "com.example.authDemo.controller.ExHandlers"})
public class AuthDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthDemoApplication.class, args);
    }

}
