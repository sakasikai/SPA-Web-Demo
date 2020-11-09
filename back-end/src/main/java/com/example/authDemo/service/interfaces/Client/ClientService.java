package com.example.authDemo.service.interfaces.Client;

import com.example.authDemo.pojo.Authentication;
import com.example.authDemo.pojo.Client;
import com.example.authDemo.pojo.DataObject.SignupObject;

import java.util.Date;

public interface ClientService {
    // client info
    public void setClient(SignupObject obj);
    public Client getClientByUserName(String userName);



    // operation
    public int getUsedNumber(int clientId, int servId);
    public int setUsedNumber(int clientId, int servId, int num);

    public int getTotalNumber(int clientId, int servId);
    public int setTotalNumber(int clientId, int servId, int num);

    public Date getStarMarkedTime(int clientId, int servId);
    public boolean setStar(int clientId, int servId, Date timeStamp);

    public Date getHistoryMarkedTime(int clientId, int servId);
    public boolean setHistory(int clientId, int servId, Date timeStamp);
}
