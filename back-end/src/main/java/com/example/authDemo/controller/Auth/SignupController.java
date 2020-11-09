package com.example.authDemo.controller.Auth;

import com.example.authDemo.model.ResultMap;
import com.example.authDemo.pojo.DataObject.LoginObject;
import com.example.authDemo.pojo.DataObject.SignupObject;
import com.example.authDemo.service.interfaces.Authentication.AuthenticationService;
import com.example.authDemo.service.interfaces.Client.ClientService;
import com.example.authDemo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController {
    private final AuthenticationService authService;
    private final ClientService clientService;
    private final ResultMap resultMap;

    @Autowired
    public SignupController(AuthenticationService authService, ClientService clientService, ResultMap resultMap) {
        this.authService = authService;
        this.clientService = clientService;
        this.resultMap = resultMap;
    }


    @RequestMapping(path = "/signup", method= RequestMethod.POST)
    public ResultMap signup(@RequestBody SignupObject model){
        if(authService.checkUserExistence(model.getUserName())){
            return resultMap.success().code(401).message(null,"用户名已存在，请重新注册");
        }else{
            authService.setUserAuth(new LoginObject(model.getUserName(), model.getPassword()));
            clientService.setClient(new SignupObject(model.getUserName(), model.getNickName()));
            return resultMap.success().code(201).message("token",JWTUtil.createToken(model.getUserName())); //前端利用token自动登录
        }
    }
}
