package com.jk.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class FruitsInfo implements Serializable {

    private Integer id;

    private String title;

    private String present;

    private Integer place;

    private Integer freight;

    private String norms;

    private Integer num;

    private BigDecimal price;

    private Integer typeId;

    private Integer auditing;

    private String reason;

    /*
     *  薛长欢
     *
     *  类型业务字段
     */
    private String typeName;

    private String placeName;

    private String img1;

    private String img2;

    private String img3;

    private String img4;//业务字段end

    private Integer amount;//数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public String getNorms() {
        return norms;
    }

    public void setNorms(String norms) {
        this.norms = norms;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAuditing() {
        return auditing;
    }

    public void setAuditing(Integer auditing) {
        this.auditing = auditing;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "FruitsInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", present='" + present + '\'' +
                ", place=" + place +
                ", freight=" + freight +
                ", norms='" + norms + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", placeName='" + placeName + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", img4='" + img4 + '\'' +
                ", amount=" + amount +
                '}';
    }
}
