package com.shangke.springcoller.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value("1")
    private String UserId;
    @Value("1")
    private String username;
    @Value("1")
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
