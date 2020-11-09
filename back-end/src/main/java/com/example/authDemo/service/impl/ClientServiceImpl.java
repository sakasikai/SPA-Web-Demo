package com.example.authDemo.service.impl;

import com.example.authDemo.mapper.UserMapper;
import com.example.authDemo.pojo.Client;
import com.example.authDemo.pojo.DataObject.SignupObject;
import com.example.authDemo.service.interfaces.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
    private final UserMapper userMapper;

    @Autowired
    public ClientServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // sign up
    @Override
    public void setClient(SignupObject obj){
        Client client = new Client(obj.getUserName(), obj.getNickName());
        userMapper.insertClient(client);
    }



    @Override
    public Client getClientByUserName(String userName) {
        return userMapper.getClientByUserName(userName);
    }

    //



    // operation
    @Override
    public int getUsedNumber(int clientId, int servId) {
        return 0;
    }

    @Override
    public int setUsedNumber(int clientId, int servId, int num) {
        return 0;
    }

    @Override
    public int getTotalNumber(int clientId, int servId) {
        return 0;
    }

    @Override
    public int setTotalNumber(int clientId, int servId, int num) {
        return 0;
    }

    @Override
    public Date getStarMarkedTime(int clientId, int servId) {
        return null;
    }

    @Override
    public boolean setStar(int clientId, int servId, Date timeStamp) {
        return false;
    }

    @Override
    public Date getHistoryMarkedTime(int clientId, int servId) {
        return null;
    }

    @Override
    public boolean setHistory(int clientId, int servId, Date timeStamp) {
        return false;
    }
}
