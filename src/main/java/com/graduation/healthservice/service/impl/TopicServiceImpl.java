package com.graduation.healthservice.service.impl;

import com.graduation.healthservice.domain.Topic;
import com.graduation.healthservice.mapper.TopicMapper;
import com.graduation.healthservice.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moyu
 * @since 2022-04-20
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

}
