package com.example.authDemo.pojo;

import java.util.Date;

public class ApplyItem {
    private int applyItemId;
    private int clientId;
    private Date timeStamp;
    private Boolean ifRepeal;
    private String applyNote;
    private int flowLevel;

    public ApplyItem(int applyItemId, int clientId, Date timeStamp, Boolean ifRepeal, String applyNote, int flowLevel) {
        this.applyItemId = applyItemId;
        this.clientId = clientId;
        this.timeStamp = timeStamp;
        this.ifRepeal = ifRepeal;
        this.applyNote = applyNote;
        this.flowLevel = flowLevel;
    }

    public int getApplyItemId() {
        return applyItemId;
    }

    public void setApplyItemId(int applyItemId) {
        this.applyItemId = applyItemId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getIfRepeal() {
        return ifRepeal;
    }

    public void setIfRepeal(Boolean ifRepeal) {
        this.ifRepeal = ifRepeal;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public int getFlowLevel() {
        return flowLevel;
    }

    public void setFlowLevel(int flowLevel) {
        this.flowLevel = flowLevel;
    }
}
