package com.jk.model;

import java.io.Serializable;

public class Tree implements Serializable {
        private String id;
        private String url;
        private String pid;
        private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
