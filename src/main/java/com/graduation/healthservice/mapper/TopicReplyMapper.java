package com.graduation.healthservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.healthservice.domain.TopicReply;
import com.graduation.healthservice.domain.TopicReplyAndUserinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author moyu
 * @since 2022-02-17
 */
public interface TopicReplyMapper extends BaseMapper<TopicReply> {
    @Select("select a.*,b.username,b.portrait from topic_reply a,userinfo b where a.phone = b.phone and a.topicid = #{topicid} and a.aim = #{aim} order by createdtime desc")
    List<TopicReplyAndUserinfo> getTopicReplyAndUser(String topicid, String aim);
    @Select("select a.*,b.username,b.portrait from topic_reply a,userinfo b where a.phone = b.phone and a.id = #{id}")
    TopicReplyAndUserinfo queryTopicReplyAndUser(String id);
}
