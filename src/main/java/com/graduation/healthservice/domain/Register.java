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
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("phone")
    private String phone;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("source")
    private String source;

    public Integer getId() {
        return id;
    }

    public Register setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getPhone() {
        return phone;
    }

    public Register setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public String getAccount() {
        return account;
    }

    public Register setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public Register setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getSource() {
        return source;
    }

    public Register setSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public String toString() {
        return "Register{" +
            "id=" + id +
            ", phone=" + phone +
            ", account=" + account +
            ", password=" + password +
            ", source=" + source +
        "}";
    }
}
