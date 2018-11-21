package com.znp.apiautotest.api.cstusercontroller.signin.bean;

public class SignInRequ {

    private String pwd;
    private String userName;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SignInResp{" +
                "pwd='" + pwd + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
