package com.example.authDemo.pojo;

public class Authentication {
    String userName;
    String passwordInDB;
    String salt; // 注册时随机生成字符串，长6位

    public Authentication(String userName, String passwordInDB, String salt) {
        this.userName = userName;
        this.passwordInDB = passwordInDB;
        this.salt = salt;
    }

    public Authentication() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPasswordInDB() {
        return passwordInDB;
    }

    public void setPasswordInDB(String passwordInDB) {
        this.passwordInDB = passwordInDB;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
