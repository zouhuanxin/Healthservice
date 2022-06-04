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
public class Foodlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("introduce")
    private String introduce;

    @TableField("url")
    private String url;

    @TableField("image")
    private String image;

    public Integer getId() {
        return id;
    }

    public Foodlist setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Foodlist setName(String name) {
        this.name = name;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public Foodlist setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public Foodlist setUrl(String url) {
        this.url = url;
        return this;
    }
    public String getImage() {
        return image;
    }

    public Foodlist setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return "Foodlist{" +
            "id=" + id +
            ", name=" + name +
            ", introduce=" + introduce +
            ", url=" + url +
            ", image=" + image +
        "}";
    }
}
