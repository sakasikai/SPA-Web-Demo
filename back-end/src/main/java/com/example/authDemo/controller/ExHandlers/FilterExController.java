package com.example.authDemo.controller.ExHandlers;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/filterEx")
@Controller
public class FilterExController {


    @RequestMapping("/jwtAuthFail")
    public void jwtAuthExHandler(HttpServletRequest request) {
        throw new AuthenticationException("无效token + "+(String) request.getAttribute("msg"));
    }
}
