package com.example.authDemo.mapper;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ClientStaffSignedMapper {

    public boolean createContractLink(int clientId, int staffId);
    public boolean deleteContractLink(int clientId, int staffId);
    public boolean getContractLink(int clientId, int staffId);

    // 双方确认
    public boolean getTalkConfirm(int clientId);
    public boolean setClientConfirm(int clientId, int staffId);

    public boolean getStaffConfirm(int staffId);
    public boolean setStaffConfirm(int clientId, int staffId);

    public Date getSignedTime(int clientId, int staffId);

    public String getStaffNote(int clientId, int staffId);
    public boolean setStaffNote(int clientId, int staffId, String note);

    public int getContractState(int clientId, int staffId);
    public boolean setContractState(int clientId, int staffId, int state);
    // contractState: -1:undefined,0:failed,1:succeed

    public boolean setFailureComment(int clientId, int staffId, String comment);
    // 为 contractState 的 failed state 添加说明
}
