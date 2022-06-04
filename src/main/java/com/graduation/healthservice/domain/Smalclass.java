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
public class Smalclass implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("introduce")
    private String introduce;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    @TableField("islegal")
    private Boolean islegal;

    public Integer getId() {
        return id;
    }

    public Smalclass setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Smalclass setName(String name) {
        this.name = name;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public Smalclass setUrl(String url) {
        this.url = url;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public Smalclass setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public Smalclass setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public Boolean getIslegal() {
        return islegal;
    }

    public Smalclass setIslegal(Boolean islegal) {
        this.islegal = islegal;
        return this;
    }

    @Override
    public String toString() {
        return "Smalclass{" +
            "id=" + id +
            ", name=" + name +
            ", url=" + url +
            ", introduce=" + introduce +
            ", createdtime=" + createdtime +
            ", islegal=" + islegal +
        "}";
    }
}
