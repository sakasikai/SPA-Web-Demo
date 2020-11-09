package com.example.authDemo.service.interfaces.Authentication;

import com.example.authDemo.pojo.Authentication;
import com.example.authDemo.pojo.Client;
import com.example.authDemo.pojo.DataObject.LoginObject;
import com.example.authDemo.pojo.DataObject.SignupObject;

public interface AuthenticationService {
    public void setUserAuth(LoginObject obj);
    public boolean checkUserExistence(String userName);

    //
    public Authentication getAuthByUserName(String userName);

}
