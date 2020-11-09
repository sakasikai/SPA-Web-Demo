package com.example.authDemo.service.interfaces.HealthSteward;

import com.example.authDemo.pojo.ApplyItem;

import java.util.List;

public interface HealthStewardService {
    public boolean createApplyItem(ApplyItem item);
    public boolean repealApplyItemById(int itemId);
    public List<ApplyItem> listApplyItems();

    public int getApplyFlowLevel(int clientId);
    public int setApplyFlowLevel(int clientId, int level);
}
