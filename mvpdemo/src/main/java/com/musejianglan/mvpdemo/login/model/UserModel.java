package com.musejianglan.mvpdemo.login.model;

/**
 * Created by liulei on 2017/12/21.
 */

public class UserModel implements IUser {

    String name;
    String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int checkName(String name, String pwd) {

        if (name.equals(this.name) && pwd.equals(this.password))
            return 0;
        else return -1;
    }
}
