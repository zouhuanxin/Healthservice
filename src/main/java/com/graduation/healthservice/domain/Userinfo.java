package com.graduation.healthservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author moyu
 * @since 2022-04-20
 */
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("phone")
    private String phone;

    @TableField("portrait")
    private String portrait;

    @TableField("username")
    private String username;

    @TableField("brithday")
    private String brithday;

    @TableField("address")
    private String address;

    @TableField("sex")
    private String sex;

    @TableField("islegal")
    private Boolean islegal;

    public Integer getId() {
        return id;
    }

    public Userinfo setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getPhone() {
        return phone;
    }

    public Userinfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public String getPortrait() {
        return portrait;
    }

    public Userinfo setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }
    public String getUsername() {
        return username;
    }

    public Userinfo setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getBrithday() {
        return brithday;
    }

    public Userinfo setBrithday(String brithday) {
        this.brithday = brithday;
        return this;
    }
    public String getAddress() {
        return address;
    }

    public Userinfo setAddress(String address) {
        this.address = address;
        return this;
    }
    public String getSex() {
        return sex;
    }

    public Userinfo setSex(String sex) {
        this.sex = sex;
        return this;
    }
    public Boolean getIslegal() {
        return islegal;
    }

    public Userinfo setIslegal(Boolean islegal) {
        this.islegal = islegal;
        return this;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
            "id=" + id +
            ", phone=" + phone +
            ", portrait=" + portrait +
            ", username=" + username +
            ", brithday=" + brithday +
            ", address=" + address +
            ", sex=" + sex +
            ", islegal=" + islegal +
        "}";
    }
}
