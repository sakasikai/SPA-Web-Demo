package com.example.authDemo.service.interfaces.ServicesConcern;

import com.example.authDemo.pojo.DataObject.SimpleServiceItem;

import java.util.List;

public interface ServiceStatistic {

    public List<SimpleServiceItem> listSimpleServices();

    public List<SimpleServiceItem> listByServType(String type);

    public List<SimpleServiceItem> listByServLevel(String level);

    public List<SimpleServiceItem> listByUsingState(String usingState);

    // echarts 统计
    public List<SimpleServiceItem> getStatisticDiagram(String type);

}
