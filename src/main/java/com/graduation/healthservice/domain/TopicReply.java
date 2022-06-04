package com.graduation.healthservice.domain;

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
public class TopicReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("topicid")
    private Integer topicid;

    @TableField("phone")
    private String phone;

    @TableField("comment")
    private String comment;

    @TableField("aim")
    private String aim;

    @TableField("createdtime")
    private LocalDateTime createdtime;

    @TableField("updatedtime")
    private LocalDateTime updatedtime;

    @TableField("replyphone")
    private String replyphone;

    public String getId() {
        return id;
    }

    public TopicReply setId(String id) {
        this.id = id;
        return this;
    }
    public Integer getTopicid() {
        return topicid;
    }

    public TopicReply setTopicid(Integer topicid) {
        this.topicid = topicid;
        return this;
    }
    public String getPhone() {
        return phone;
    }

    public TopicReply setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public String getComment() {
        return comment;
    }

    public TopicReply setComment(String comment) {
        this.comment = comment;
        return this;
    }
    public String getAim() {
        return aim;
    }

    public TopicReply setAim(String aim) {
        this.aim = aim;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public TopicReply setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public TopicReply setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }
    public String getReplyphone() {
        return replyphone;
    }

    public TopicReply setReplyphone(String replyphone) {
        this.replyphone = replyphone;
        return this;
    }

    @Override
    public String toString() {
        return "TopicReply{" +
            "id=" + id +
            ", topicid=" + topicid +
            ", phone=" + phone +
            ", comment=" + comment +
            ", aim=" + aim +
            ", createdtime=" + createdtime +
            ", updatedtime=" + updatedtime +
            ", replyphone=" + replyphone +
        "}";
    }
}
