package com.example.authDemo.pojo;

public class Client {
    String userName;
    String nickName;

    public Client(String name, String nickName) {
        this.userName = name;
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
