package com.graduation.healthservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.*;
import com.graduation.healthservice.mapper.TopicMapper;
import com.graduation.healthservice.service.ICollectService;
import com.graduation.healthservice.service.IFavourService;
import com.graduation.healthservice.service.ITopicService;
import com.graduation.healthservice.tools.TextCensor;
import lombok.val;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/health/TopicController")
public class TopicController {
    @Resource
    private ITopicService iTopicService;

    @Resource
    private TopicMapper topicmapper;

    @Resource
    private IFavourService iFavourService;

    @Resource
    private ICollectService iCollectService;

    //添加一条动态
    @PostMapping("addTopic")
    public Future<JsonResult> addTopic(@RequestBody Topic topic) {
        System.out.println("添加一条动态");
        if (topic.getUser() == null) return new AsyncResult<>(JsonResult.error("用户id不能为空"));
        if (topic.getIntroduce() == null) return new AsyncResult<>(JsonResult.error("内容不能为空"));
        //检查话题敏感度
        Future<JsonResult> check = TextCensor.TextCensor(topic.getIntroduce());
        try {
            if (check.get().toString().indexOf("不合规") != -1){
                return new AsyncResult<>(JsonResult.error("内容不合规"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AsyncResult<>(JsonResult.error("添加失败"));
        }
        if (iTopicService.save(topic)) {
            return new AsyncResult<>(JsonResult.succeed("添加成功"));
        }
        return new AsyncResult<>(JsonResult.error("添加失败"));
    }

    //删除一条动态
    @PostMapping("deleteTopic")
    public JsonResult deleteTopic(@RequestBody Topic topic) {
        if (topic.getId() == null) return JsonResult.error("id不能为空");
        if (iTopicService.removeById(topic)) {
            return JsonResult.succeed("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    //获取信息 分页查询
    @GetMapping("getPageData")
    public JsonResult getPageData(int page, int limit, String user, String type) {
        int p = (page - 1) * limit;
        List<TopicAndUser> res = topicmapper.getTopicAndUser(p, limit, type);
        //利用手机号查询此用户是否点赞 是否收藏
        for (TopicAndUser em : res) {
            Favour f = iFavourService.getOne(new QueryWrapper<Favour>().eq("topic", em.getId()).eq("user", user));
            Collect c = iCollectService.getOne(new QueryWrapper<Collect>().eq("topic", em.getId()).eq("user", user));
            em.setDz(f != null);
            em.setSc(c != null);
        }
        return JsonResult.succeed("查询成果", res);
    }


    //根据分类获取信息 分页查询
    @GetMapping("getPageData2")
    public JsonResult getPageData2(int page, int limit, String user, int typeid) {
        int p = (page - 1) * limit;
        List<TopicAndUser> res = topicmapper.getTopicAndUser2(p, limit, typeid);
        //利用手机号查询此用户是否点赞 是否收藏
        for (TopicAndUser em : res) {
            Favour f = iFavourService.getOne(new QueryWrapper<Favour>().eq("topic", em.getId()).eq("user", user));
            Collect c = iCollectService.getOne(new QueryWrapper<Collect>().eq("topic", em.getId()).eq("user", user));
            em.setDz(f != null);
            em.setSc(c != null);
        }
        return JsonResult.succeed("查询成果", res);
    }

    /**
     * 返回所有话题信息
     */
    @GetMapping("getAllTopic")
    public JsonResult getAllTopic(){
        return JsonResult.succeed("查询成功",iTopicService.list());
    }


}
