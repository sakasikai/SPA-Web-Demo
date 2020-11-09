package com.example.authDemo.service;

import com.example.authDemo.pojo.DataObject.LoginObject;
import com.example.authDemo.service.interfaces.Authentication.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    private final AuthenticationService authService;

    @Autowired
    public AuthServiceTest(AuthenticationService authService) {
        this.authService = authService;
    }

    @Test
    public void signupTest(){
        LoginObject model = new LoginObject("adminx", "123");
        authService.setUserAuth(new LoginObject(model.getUserName(), model.getPassword()));
        System.out.println(authService.checkUserExistence(model.getUserName()));
        System.out.println(authService.getAuthByUserName(model.getUserName()));
    }
}
