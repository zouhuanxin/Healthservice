package com.graduation.healthservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.healthservice.domain.Topic;
import com.graduation.healthservice.domain.TopicAndUser;
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
public interface TopicMapper extends BaseMapper<Topic> {
    @Select("select a.*,b.username,b.portrait,b.sex,c.`name` from topic a,userinfo b,smalclass c where a.type = #{type} and a.user = b.phone and a.smalclass = c.id limit #{page},#{limit}")
    List<TopicAndUser> getTopicAndUser(int page, int limit,String type);

    @Select("select a.*,b.username,b.portrait,b.sex,c.`name` from topic a,userinfo b,smalclass c where a.user = b.phone and a.smalclass = c.id and a.smalclass = #{typeid} and a.type = '0' limit #{page},#{limit}")
    List<TopicAndUser> getTopicAndUser2(int page, int limit, int typeid);

}
