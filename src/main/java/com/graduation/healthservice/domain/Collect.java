package com.graduation.healthservice.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user")
    private String user;

    @TableField("topic")
    private String topic;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    public Integer getId() {
        return id;
    }

    public Collect setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getUser() {
        return user;
    }

    public Collect setUser(String user) {
        this.user = user;
        return this;
    }
    public String getTopic() {
        return topic;
    }

    public Collect setTopic(String topic) {
        this.topic = topic;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public Collect setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }

    @Override
    public String toString() {
        return "Collect{" +
            "id=" + id +
            ", user=" + user +
            ", topic=" + topic +
            ", createdtime=" + createdtime +
        "}";
    }
}
