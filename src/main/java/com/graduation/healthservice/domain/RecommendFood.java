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
public class RecommendFood implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("image")
    private String image;

    @TableField("introduce")
    private String introduce;

    @TableField("url")
    private String url;

    @TableField("state")
    private Boolean state;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    @TableField("updatedtime")
    private LocalDateTime updatedtime;

    @TableField("season")
    private String season;

    @TableField("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public RecommendFood setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getImage() {
        return image;
    }

    public RecommendFood setImage(String image) {
        this.image = image;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public RecommendFood setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public RecommendFood setUrl(String url) {
        this.url = url;
        return this;
    }
    public Boolean getState() {
        return state;
    }

    public RecommendFood setState(Boolean state) {
        this.state = state;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public RecommendFood setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public RecommendFood setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }
    public String getSeason() {
        return season;
    }

    public RecommendFood setSeason(String season) {
        this.season = season;
        return this;
    }
    public String getName() {
        return name;
    }

    public RecommendFood setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "RecommendFood{" +
            "id=" + id +
            ", image=" + image +
            ", introduce=" + introduce +
            ", url=" + url +
            ", state=" + state +
            ", createdtime=" + createdtime +
            ", updatedtime=" + updatedtime +
            ", season=" + season +
            ", name=" + name +
        "}";
    }
}
