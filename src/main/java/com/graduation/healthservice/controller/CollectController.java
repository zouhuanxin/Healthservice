package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.Collect;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.service.ICollectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/health/CollectController")
public class CollectController {

    @Resource
    private ICollectService iCollectService;

    //收藏
    @GetMapping("collect")
    public JsonResult collect(String id, String user) {
        //先查询是否已经收藏
        Collect r1 = iCollectService.getOne(new QueryWrapper<Collect>().eq("topic", id).eq("user", user));
        if (r1 != null) {
            boolean r2 = iCollectService.remove(new QueryWrapper<Collect>().eq("topic", id).eq("user", user));
            if (r2) {
                return JsonResult.succeed("取消收藏成功");
            }
            return JsonResult.succeed("取消收藏失败");
        }
        Collect f = new Collect();
        f.setTopic(id);
        f.setUser(user);
        if (iCollectService.save(f)) {
            return JsonResult.succeed("收藏成功");
        }
        return JsonResult.succeed("收藏失败");
    }

}

