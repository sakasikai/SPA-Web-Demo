package com.example.authDemo.service.interfaces.HealthSteward;

public interface ClientStaffTalkLink {
    public boolean checkIfConfirmed(int clientId);
    public boolean setConfirmed(int clientId, int staffId);


    public String getStaffNote(int clientId, int staffId);
    public boolean setStaffNote(int clientId, int staffId, String note);
}
