package com.example.authDemo.mapper;

import com.example.authDemo.pojo.Authentication;
import com.example.authDemo.pojo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testAuth(){
        int cnt=1;

        userMapper.insertAuth(new Authentication("mr.hua", "hua123", "abc"));
        Authentication hua = userMapper.getAuthByName("mr.hua");
        System.out.println("test"+(cnt++)+"for insert operation: "+hua.getUserName()+"'s pwd:"+hua.getPasswordInDB()+",salt: "+hua.getSalt());

        userMapper.updateAuth(new Authentication("mr.hua", "huaxxx", "mzc"));
        Authentication hua1 = userMapper.getAuthByName("mr.hua");
        System.out.println("test"+(cnt++)+"for update operation: "+hua1.getUserName()+"'s pwd:"+hua1.getPasswordInDB()+",salt: "+hua1.getSalt());

        userMapper.deleteAuth("mr.hua");
        Authentication hua2 = userMapper.getAuthByName("mr.hua");
        boolean deleteRes = hua2==null?true:false;
        System.out.println("test"+(cnt++)+"for delete operation: "+deleteRes);
    }

    @Test
    public void testClient(){
        int cnt=1;

        userMapper.insertClient(new Client("mr.hua", "xiao hua"));
        Client client = userMapper.getClientByUserName("mr.hua");
        System.out.println("test"+(cnt++)+"for Client operation: "+client.getUserName()+"'s nickname:"+client.getNickName());
    }
}
