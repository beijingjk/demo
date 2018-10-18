package com.jk.model;

import java.io.Serializable;

public class Login  implements Serializable {

    private String loginId;
    private String userName;
    private String loginName;
    private String loginPhone;
    private String loginpasswrd;
    private String loginEmail;
    private Integer loginSex;
    private String loginBirthday;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone;
    }

    public String getLoginpasswrd() {
        return loginpasswrd;
    }

    public void setLoginpasswrd(String loginpasswrd) {
        this.loginpasswrd = loginpasswrd;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public Integer getLoginSex() {
        return loginSex;
    }

    public void setLoginSex(Integer loginSex) {
        this.loginSex = loginSex;
    }

    public String getLoginBirthday() {
        return loginBirthday;
    }

    public void setLoginBirthday(String loginBirthday) {
        this.loginBirthday = loginBirthday;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId='" + loginId + '\'' +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPhone='" + loginPhone + '\'' +
                ", loginpasswrd='" + loginpasswrd + '\'' +
                ", loginEmail='" + loginEmail + '\'' +
                ", loginSex=" + loginSex +
                ", loginBirthday='" + loginBirthday + '\'' +
                '}';
    }
}
