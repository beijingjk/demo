package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable {

    private String userId;

    private String sincerityName;//真实姓名

    private String payPasswork;//支付密码

    private String userPassword;//登录密码

    private String userName;//用户名称

    private String userPhone;//用户手机号

    private String userEmail;//用户邮箱

    private String userSex;//用户性别（1 男   2 女）

    private String userBirthday;//用户生日

    private String userImg;//用户头像

    private String userBalance;//用户余额

    private String userStatus;//用户状态（是否为会员）

    private String userIntegral;//用户积分

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayPasswork() {
        return payPasswork;
    }

    public void setPayPasswork(String payPasswork) {
        this.payPasswork = payPasswork;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(String userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(String userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getSincerityName() {
        return sincerityName;
    }

    public void setSincerityName(String sincerityName) {
        this.sincerityName = sincerityName;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId='" + userId + '\'' +
                ", sincerityName='" + sincerityName + '\'' +
                ", payPasswork='" + payPasswork + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userBalance='" + userBalance + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userIntegral='" + userIntegral + '\'' +
                '}';
    }
}
