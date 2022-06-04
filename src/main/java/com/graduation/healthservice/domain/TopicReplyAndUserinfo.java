package com.graduation.healthservice.domain;

import java.time.LocalDateTime;

public class TopicReplyAndUserinfo extends TopicReply {

    private String id;

    private Integer topicid;

    private String phone;

    private String comment;

    private String aim;

    private LocalDateTime createdtime;

    private LocalDateTime updatedtime;

    private String portrait;

    private String username;

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public TopicReplyAndUserinfo setId(String id) {
        this.id = id;
        return this;
    }
    public Integer getTopicid() {
        return topicid;
    }

    public TopicReplyAndUserinfo setTopicid(Integer topicid) {
        this.topicid = topicid;
        return this;
    }
    public String getPhone() {
        return phone;
    }

    public TopicReplyAndUserinfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public String getComment() {
        return comment;
    }

    public TopicReplyAndUserinfo setComment(String comment) {
        this.comment = comment;
        return this;
    }
    public String getAim() {
        return aim;
    }

    public TopicReplyAndUserinfo setAim(String aim) {
        this.aim = aim;
        return this;
    }
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public TopicReplyAndUserinfo setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
        return this;
    }
    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public TopicReplyAndUserinfo setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }

    @Override
    public String toString() {
        return "TopicReplyAndUserinfo{" +
                "id='" + id + '\'' +
                ", topicid=" + topicid +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", aim='" + aim + '\'' +
                ", createdtime=" + createdtime +
                ", updatedtime=" + updatedtime +
                ", portrait='" + portrait + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
