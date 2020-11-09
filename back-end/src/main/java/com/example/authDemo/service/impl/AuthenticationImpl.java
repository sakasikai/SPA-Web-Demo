package com.example.authDemo.service.impl;

import com.example.authDemo.mapper.UserMapper;
import com.example.authDemo.pojo.Authentication;
import com.example.authDemo.pojo.DataObject.LoginObject;
import com.example.authDemo.service.interfaces.Authentication.AuthenticationService;
import com.example.authDemo.utils.RandomStrUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthenticationService")
public class AuthenticationImpl implements AuthenticationService {

    private final UserMapper userMapper;

    @Autowired
    public AuthenticationImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public void setUserAuth(LoginObject obj){
        // 随机生成salt，并生成passwordInDB，存储

        Authentication auth = new Authentication();
        auth.setUserName(obj.getUserName());
        auth.setSalt(RandomStrUtil.generateString(10));

        // 此处加密算法要和shiro身份认证里的算法一致！！！
        auth.setPasswordInDB(new Md5Hash(obj.getPassword(), auth.getSalt(), 2).toString());
        userMapper.insertAuth(auth);
    }

    public boolean checkUserExistence(String userName){
        // Auth里字段不空,则用户存在
        Authentication auth = userMapper.getAuthByName(userName);
        if(auth!=null && auth.getPasswordInDB()!=null && auth.getSalt()!=null){
            return true;
        }
        return false;
    };

    @Override
    public Authentication getAuthByUserName(String userName) {
        return userMapper.getAuthByName(userName);
    }
}
