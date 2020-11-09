package com.example.authDemo.controller.ShoppingMall;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ShoppingMall")
public class ShoppingMallController {

    @RequestMapping("/AllServices")
    public String listSimpleServices(){

        return null;
    }

    @RequestMapping("/details/{servId}/ServiceInfo")
    public String getServiceInfo(@PathVariable int servId){

        return null;
    }

    @RequestMapping("/details/{servId}/ServiceBuy")
    public String buyService(@PathVariable int servId,
                             @RequestParam int num){

        return null;
    }

    @RequestMapping("/details/{servId}/ServiceStar")
    public String starService(@PathVariable int servId){

        return null;
    }
}
