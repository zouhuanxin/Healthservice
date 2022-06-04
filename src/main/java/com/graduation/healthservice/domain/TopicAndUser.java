package com.graduation.healthservice.domain;

public class TopicAndUser extends Topic{

    private String portrait;

    private String username;

    private String sex;

    private String name;

    private Boolean dz;

    private Boolean sc;

    public Boolean getDz() {
        return dz;
    }

    public void setDz(Boolean dz) {
        this.dz = dz;
    }

    public Boolean getSc() {
        return sc;
    }

    public void setSc(Boolean sc) {
        this.sc = sc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
