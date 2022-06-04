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
public class CalorieHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("introduce")
    private String introduce;

    @TableField("calorie")
    private String calorie;

    @TableField("user")
    private String user;

    @TableField("url")
    private String url;

    @TableField("createdtime")
    private String createdtime;

    @TableField("href")
    private String href;

    public Integer getId() {
        return id;
    }

    public CalorieHistory setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public CalorieHistory setName(String name) {
        this.name = name;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public CalorieHistory setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getCalorie() {
        return calorie;
    }

    public CalorieHistory setCalorie(String calorie) {
        this.calorie = calorie;
        return this;
    }
    public String getUser() {
        return user;
    }

    public CalorieHistory setUser(String user) {
        this.user = user;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public CalorieHistory setUrl(String url) {
        this.url = url;
        return this;
    }
    public String getCreatedtime() {
        return createdtime;
    }

    public CalorieHistory setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public String getHref() {
        return href;
    }

    public CalorieHistory setHref(String href) {
        this.href = href;
        return this;
    }

    @Override
    public String toString() {
        return "CalorieHistory{" +
            "id=" + id +
            ", name=" + name +
            ", introduce=" + introduce +
            ", calorie=" + calorie +
            ", user=" + user +
            ", url=" + url +
            ", createdtime=" + createdtime +
            ", href=" + href +
        "}";
    }
}
