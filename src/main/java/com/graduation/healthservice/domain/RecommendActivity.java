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
public class RecommendActivity implements Serializable {

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

    @TableField("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public RecommendActivity setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getImage() {
        return image;
    }

    public RecommendActivity setImage(String image) {
        this.image = image;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public RecommendActivity setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public RecommendActivity setUrl(String url) {
        this.url = url;
        return this;
    }
    public Boolean getState() {
        return state;
    }

    public RecommendActivity setState(Boolean state) {
        this.state = state;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public RecommendActivity setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public RecommendActivity setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }
    public String getName() {
        return name;
    }

    public RecommendActivity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "RecommendActivity{" +
            "id=" + id +
            ", image=" + image +
            ", introduce=" + introduce +
            ", url=" + url +
            ", state=" + state +
            ", createdtime=" + createdtime +
            ", updatedtime=" + updatedtime +
            ", name=" + name +
        "}";
    }
}
