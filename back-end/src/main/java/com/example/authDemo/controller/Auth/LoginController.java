package com.example.authDemo.controller.Auth;


import com.example.authDemo.model.ResultMap;
import com.example.authDemo.pojo.DataObject.LoginObject;
import com.example.authDemo.service.interfaces.Client.ClientService;
import com.example.authDemo.shiro.CustomToken;
import com.example.authDemo.utils.AuthenticationType;
import com.example.authDemo.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class LoginController {

    private final ClientService clientService;
    private final ResultMap resultMap;

    @Autowired
    public LoginController(ClientService clientService, ResultMap resultMap) {
        this.clientService = clientService;
        this.resultMap = resultMap;
    }

    @RequestMapping(path = "/login", method= RequestMethod.POST)
    public ResultMap login(@RequestBody LoginObject model){
        CustomToken token = new CustomToken(
                model.getUserName(),
                model.getPassword(),
                AuthenticationType.UsernamePassword);
        SecurityUtils.getSubject().login(token);
        return resultMap.success().code(200).message("token",JWTUtil.createToken(model.getUserName()));
    }

    @RequestMapping(path = "/userInfo")
    public ResultMap getUserInfo(@RequestParam String userName){
        return resultMap.success().code(200).message("clientInfo",clientService.getClientByUserName(userName));
    }

    @RequestMapping(path = "/logout/{userName}")
    public ResultMap logout(@PathVariable String userName){
        return null;
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws AuthenticationException,UnsupportedEncodingException {
        System.out.println("Redirected to unauthorized page, the response msg is:"+message);
        return resultMap.fail().code(401).message(null,message);
    }
}
