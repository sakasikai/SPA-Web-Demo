package com.example.authDemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/{userName}/ServStatistic")
public class ServStatisticController {

    @RequestMapping("/OwnedServices")
    public String listSimpleServices(@PathVariable String userName){

        return null;
    }

    @RequestMapping("/OwnedServicesByType")
    public String listSimpleServicesByType(@PathVariable String userName,
                                         @RequestParam String servType){

        return null;
    }

    @RequestMapping("/OwnedServicesByLevel")
    public String listSimpleServicesByLevel(@PathVariable String userName,
                                            @RequestParam String level){

        return null;
    }

    @RequestMapping("/OwnedServicesByState")
    public String listSimpleServicesByState(@PathVariable String userName,
                                            @RequestParam String usingState){

        return null;
    }

    @RequestMapping("/Statistic")
    public String ServicesStatistic(@PathVariable String userName,
                                    @RequestParam String type){

        // 不同type的统计图

        return null;
    }
}
