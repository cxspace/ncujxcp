package com.cx.user.entity;

/**
 * Created by liujie on 2017/2/23.
 */
public class User {

    private String id;

    private String account;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String reserve;

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String id, String account, String password, String reserve) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }
}
