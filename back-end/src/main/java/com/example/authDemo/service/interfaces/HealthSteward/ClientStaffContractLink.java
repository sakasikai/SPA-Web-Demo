package com.example.authDemo.service.interfaces.HealthSteward;

import com.example.authDemo.pojo.DataObject.CommentItem;
import com.example.authDemo.pojo.DataObject.SimpleClientItem;

import java.util.Date;
import java.util.List;

public interface ClientStaffContractLink {
    public boolean checkIfClientConfirmed(int clientId, int staffId);
    public boolean setClientConfirm(int clientId, int staffId);

    public boolean checkIfStaffConfirmed(int clientId, int staffId);
    public boolean setStaffConfirm(int clientId, int staffId);

    public Date getSignedTime(int clientId, int staffId);

    public String getStaffNote(int clientId, int staffId);
    public boolean setStaffNote(int clientId, int staffId, String note);

    public int getContractState(int clientId, int staffId);
    public boolean setContractState(int clientId, int staffId, int state);
    // contractState: -1:undefined,0:failed,1:succeed

    public boolean setFailureComment(int clientId, int staffId, String comment);
    // 为 contractState 的 failed state 添加说明


    // 管理已签约用户
    public List<SimpleClientItem> getAllSignedClients(int staffId);
}
