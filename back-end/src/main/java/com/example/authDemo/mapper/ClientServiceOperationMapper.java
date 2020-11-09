package com.example.authDemo.mapper;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ClientServiceOperationMapper {

    public boolean createUseLink(int clientId, int servId, int used, int total);
    public boolean deleteUseLink(int clientId, int servId);

    public int getUsed(int clientId, int servId);
    public boolean setUsed(int clientId, int servId, int num);

    public int getTotal(int clientId, int servId);
    public boolean setTotal(int clientId, int servId, int num);

    public Date getStarCreatedTime(int clientId, int servId);
    public boolean createStarLink(int clientId, int servId, Date timeStamp);

    public Date getHistoryCreatedTime(int clientId, int servId);
    public boolean createHistoryLink(int clientId, int servId, Date timeStamp);
}
