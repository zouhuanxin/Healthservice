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
public class PunchCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("day")
    private String day;

    @TableField("user")
    private String user;

    public Integer getId() {
        return id;
    }

    public PunchCard setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getDay() {
        return day;
    }

    public PunchCard setDay(String day) {
        this.day = day;
        return this;
    }
    public String getUser() {
        return user;
    }

    public PunchCard setUser(String user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "PunchCard{" +
            "id=" + id +
            ", day=" + day +
            ", user=" + user +
        "}";
    }
}
