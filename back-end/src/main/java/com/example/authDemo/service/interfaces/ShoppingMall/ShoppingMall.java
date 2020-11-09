package com.example.authDemo.service.interfaces.ShoppingMall;

import com.example.authDemo.pojo.DataObject.SimpleServiceItem;

import java.util.List;

public interface ShoppingMall {

    public List<SimpleServiceItem> listSimpleServices();

    public List<SimpleServiceItem> listByServType(String type);

    public List<SimpleServiceItem> listByServLevel(String level);

    public List<SimpleServiceItem> listByUsingState(String usingState);


}
