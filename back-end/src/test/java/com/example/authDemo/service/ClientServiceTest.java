package com.example.authDemo.service;

import com.example.authDemo.pojo.DataObject.SignupObject;
import com.example.authDemo.service.interfaces.Client.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTest {
    private final ClientService clientService;

    @Autowired
    public ClientServiceTest(ClientService clientService) {
        this.clientService = clientService;
    }

    @Test
    public void signupTest(){
        SignupObject model = new SignupObject("admin", "hua");
        clientService.setClient(new SignupObject(model.getUserName(), model.getNickName()));
        System.out.println(clientService.getClientByUserName(model.getUserName()));
    }
}
