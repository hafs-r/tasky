package com.hafsalrahman.tasky.signin;

/**
 * Created by hafsal on 7/23/17.
 */

public class User {

    private final String userId;
    private final String createdAt;
    private final String userName;
    private final String passWord;

    public User(String userId, String createdAt, String userName, String passWord) {
        this.userId = userId;
        this.createdAt = createdAt;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
