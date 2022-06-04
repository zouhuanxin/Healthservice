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
public class LaunchPageAdvertisement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("introduce")
    private String introduce;

    @TableField("url")
    private String url;

    @TableField("isable")
    private Boolean isable;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    @TableField("updatedtime")
    private LocalDateTime updatedtime;

    @TableField("effectiveday")
    private String effectiveday;

    public Integer getId() {
        return id;
    }

    public LaunchPageAdvertisement setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getIntroduce() {
        return introduce;
    }

    public LaunchPageAdvertisement setIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public LaunchPageAdvertisement setUrl(String url) {
        this.url = url;
        return this;
    }
    public Boolean getIsable() {
        return isable;
    }

    public LaunchPageAdvertisement setIsable(Boolean isable) {
        this.isable = isable;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public LaunchPageAdvertisement setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public LaunchPageAdvertisement setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }
    public String getEffectiveday() {
        return effectiveday;
    }

    public LaunchPageAdvertisement setEffectiveday(String effectiveday) {
        this.effectiveday = effectiveday;
        return this;
    }

    @Override
    public String toString() {
        return "LaunchPageAdvertisement{" +
            "id=" + id +
            ", introduce=" + introduce +
            ", url=" + url +
            ", isable=" + isable +
            ", createdtime=" + createdtime +
            ", updatedtime=" + updatedtime +
            ", effectiveday=" + effectiveday +
        "}";
    }
}
