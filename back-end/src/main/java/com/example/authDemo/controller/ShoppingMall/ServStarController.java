package com.example.authDemo.controller.ShoppingMall;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/{userName}/StarServices")
public class ServStarController {
    @RequestMapping("Show")
    public String listStarServices(@PathVariable String userName){

        return null;
    }
}
