package com.graduation.healthservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.TopicReply;
import com.graduation.healthservice.domain.TopicReplyAndUserinfo;
import com.graduation.healthservice.mapper.TopicReplyMapper;
import com.graduation.healthservice.service.ITopicReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/health/TopicReplyController")
public class TopicReplyController {
    @Resource
    private ITopicReplyService iTopicReplyService;

    @Resource
    private TopicReplyMapper iTopicReplyMapper;

    //添加一条评论
    @PostMapping("addTopicReply")
    public JsonResult addTopic(@RequestBody TopicReply topicReply) {
        if (topicReply.getComment() == null) return JsonResult.error("评论内容不能为空");
        if (topicReply.getPhone() == null) return JsonResult.error("操作对象不能为空");
        if (topicReply.getTopicid() == null) return JsonResult.error("帖子id不能为空");
        if (topicReply.getAim() == null) return JsonResult.error("评论对象不能为空");
        if (topicReply.getReplyphone() == null) return JsonResult.error("回复对象不能为空");
        topicReply.setId(UUID.randomUUID().toString());
        if (iTopicReplyService.save(topicReply)) {
            return JsonResult.succeed("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    //默认不可以删除评论
    //管理员才可以删除评论
    //删除一条评论


    //根据帖子id和aim获取所需要的所有的评论信息
    //这是第一种方式此种方式会返回整个帖子的所有评论信息以及每条评论对应的回复信息
    //此处毕业设计不做分页处理
    //工厂模式下需要做分页处理
    @GetMapping("getCommentData1")
    public JsonResult getCommentData1(String topicid,String aim) {
        //第一步 先查询帖子下面的所有评论信息
        List<TopicReply> r1 = iTopicReplyService.list(new QueryWrapper<TopicReply>().eq("topicid",topicid).eq("aim",aim));
        //第二部 根据每条评论去查询每条评论下面的回复信息组成一组json数据
        JSONArray res = new JSONArray();
        for (TopicReply emen : r1) {
            JSONArray temp = new JSONArray();
            TopicReplyAndUserinfo t = iTopicReplyMapper.queryTopicReplyAndUser(emen.getId());
            temp.add(t);
            query(temp, topicid, emen.getId());
            res.add(temp);
        }
        return JsonResult.succeed("查询成功", res);
    }

    //递归查找
    private void query(JSONArray temp,String topicid,String aim) {
        List<TopicReplyAndUserinfo> r2 = iTopicReplyMapper.getTopicReplyAndUser(topicid, aim);
        if (r2.size() == 0){
            return;
        }
        for (TopicReplyAndUserinfo emen2 : r2) {
            temp.add(emen2);
            query(temp, topicid, emen2.getId());
        }
    }
}
