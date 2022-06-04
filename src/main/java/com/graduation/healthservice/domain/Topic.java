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
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("urls")
    private String urls;

    @TableField("introduce")
    private String introduce;

    @TableField("source")
    private String source;

    @TableField("smalclass")
    private Integer smalclass;

    @TableField("heat")
    private Integer heat;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    @TableField("updatedtime")
    private LocalDateTime updatedtime;

    @TableField("user")
    private String user;

    @TableField("type")
    private Integer type;

    public Integer getId() {
        return id;
    }

    public Topic setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getUrls() {
        return urls;
    }

    public Topic setUrls(String urls) {
        this.urls = urls;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public Topic setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getSource() {
        return source;
    }

    public Topic setSource(String source) {
        this.source = source;
        return this;
    }
    public Integer getSmalclass() {
        return smalclass;
    }

    public Topic setSmalclass(Integer smalclass) {
        this.smalclass = smalclass;
        return this;
    }
    public Integer getHeat() {
        return heat;
    }

    public Topic setHeat(Integer heat) {
        this.heat = heat;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public Topic setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public Topic setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }
    public String getUser() {
        return user;
    }

    public Topic setUser(String user) {
        this.user = user;
        return this;
    }
    public Integer getType() {
        return type;
    }

    public Topic setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Topic{" +
            "id=" + id +
            ", urls=" + urls +
            ", introduce=" + introduce +
            ", source=" + source +
            ", smalclass=" + smalclass +
            ", heat=" + heat +
            ", createdtime=" + createdtime +
            ", updatedtime=" + updatedtime +
            ", user=" + user +
            ", type=" + type +
        "}";
    }
}
