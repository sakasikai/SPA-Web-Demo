package com.example.authDemo.controller.ShoppingMall;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/{userName}/HistoryServices")
public class ServHistoryController {

    @RequestMapping("Show")
    public String listHistoryServices(@PathVariable String userName){

        return null;
    }
}
