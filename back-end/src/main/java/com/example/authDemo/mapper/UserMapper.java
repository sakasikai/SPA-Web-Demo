package com.example.authDemo.mapper;

import com.example.authDemo.pojo.Authentication;
import com.example.authDemo.pojo.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    // Authentication
    void insertAuth(Authentication auth);
    void deleteAuth(String userName);
    void updateAuth(Authentication auth);
    Authentication getAuthByName(String userName);

    // ClientInfo, StaffInfo
    void insertClient(Client client);
    Client getClientByUserName(String userName);
}
