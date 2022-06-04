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
public class FoodlistFavour implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user")
    private String user;

    @TableField("foodlistid")
    private Integer foodlistid;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    public Integer getId() {
        return id;
    }

    public FoodlistFavour setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getUser() {
        return user;
    }

    public FoodlistFavour setUser(String user) {
        this.user = user;
        return this;
    }
    public Integer getFoodlistid() {
        return foodlistid;
    }

    public FoodlistFavour setFoodlistid(Integer foodlistid) {
        this.foodlistid = foodlistid;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public FoodlistFavour setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }

    @Override
    public String toString() {
        return "FoodlistFavour{" +
            "id=" + id +
            ", user=" + user +
            ", foodlistid=" + foodlistid +
            ", createdtime=" + createdtime +
        "}";
    }
}
