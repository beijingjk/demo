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
                '}';
    }
}
