package com.example.authDemo.service.interfaces.ServicesConcern;

import com.example.authDemo.pojo.DataObject.HistoryServiceItem;
import com.example.authDemo.pojo.DataObject.StarServiceItem;

import java.util.List;

public interface StarService {
    public List<StarServiceItem> listByTime(String month);
}
