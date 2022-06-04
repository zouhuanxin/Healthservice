package com.graduation.healthservice.domain;

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
public class Foodhistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("introduce")
    private String introduce;

    @TableField("calorie")
    private String calorie;

    public Integer getId() {
        return id;
    }

    public Foodhistory setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Foodhistory setName(String name) {
        this.name = name;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public Foodhistory setUrl(String url) {
        this.url = url;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public Foodhistory setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getCalorie() {
        return calorie;
    }

    public Foodhistory setCalorie(String calorie) {
        this.calorie = calorie;
        return this;
    }

    @Override
    public String toString() {
        return "Foodhistory{" +
            "id=" + id +
            ", name=" + name +
            ", url=" + url +
            ", introduce=" + introduce +
            ", calorie=" + calorie +
        "}";
    }
}
