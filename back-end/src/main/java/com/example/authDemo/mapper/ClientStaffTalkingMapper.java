package com.example.authDemo.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaffTalkingMapper {

    public boolean createTalkLink(int clientId, int staffId);
    public boolean deleteTalkLink(int clientId, int staffId);

    public boolean getTalkConfirm(int clientId);

    public String getStaffNote(int clientId, int staffId);
    public boolean setStaffNote(int clientId, int staffId, String note);
}
