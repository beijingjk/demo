package com.jk.model;

import java.io.Serializable;

public class PetType implements Serializable {

    private String ptid;

    private String pttype;

    private String ptname;

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public String getPttype() {
        return pttype;
    }

    public void setPttype(String pttype) {
        this.pttype = pttype;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "ptid='" + ptid + '\'' +
                ", pttype='" + pttype + '\'' +
                ", ptname='" + ptname + '\'' +
                '}';
    }
}
