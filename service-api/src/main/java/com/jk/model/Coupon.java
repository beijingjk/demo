package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {

    private String  id;

    private String userId;       //登陆人ID

    private String faceValue;     //面值

    private String name;        //优惠券名称

    private String maxPrice;   //满多少元可以使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;   //优惠券初始时间


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;   //优惠券结束时间

    private String status;       //优惠券状态(1:使用2:已使用3:过期)

    private String cnumber;   //优惠券代码

    private Integer ccount;    //优惠券个数
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdqDate;  //查到期时间临时字段
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date edqDate;  //查到期时间临时字段

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public Date getSdqDate() {
        return sdqDate;
    }

    public void setSdqDate(Date sdqDate) {
        this.sdqDate = sdqDate;
    }

    public Date getEdqDate() {
        return edqDate;
    }

    public void setEdqDate(Date edqDate) {
        this.edqDate = edqDate;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", faceValue='" + faceValue + '\'' +
                ", name='" + name + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", ccount=" + ccount +
                ", sdqDate=" + sdqDate +
                ", edqDate=" + edqDate +
                '}';
    }
}
