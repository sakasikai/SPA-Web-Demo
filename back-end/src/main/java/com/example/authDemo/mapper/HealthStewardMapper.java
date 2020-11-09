package com.example.authDemo.mapper;

import com.example.authDemo.pojo.ApplyItem;
import com.example.authDemo.pojo.DataObject.SimpleClientItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthStewardMapper {



    public boolean createApplyItem(ApplyItem item);
    public boolean deleteApplyItem(int id);

    public int getFlowLevel();
    public int setFlowLevel(int level);

    // staff
    public List<ApplyItem> getAllApplyItems();

    public List<SimpleClientItem> getAllSignedClients();

}
