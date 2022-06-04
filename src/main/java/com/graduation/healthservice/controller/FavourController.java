package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.Favour;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.service.IFavourService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/health/FavourController")
public class FavourController {
    @Resource
    private IFavourService iFavourService;

    //点赞
    @GetMapping("favour")
    public JsonResult favour(String id, String user) {
        //先查询是否已经点赞
        Favour r1 = iFavourService.getOne(new QueryWrapper<Favour>().eq("topic", id).eq("user", user));
        if (r1 != null) {
            boolean r2 = iFavourService.remove(new QueryWrapper<Favour>().eq("topic", id).eq("user", user));
            if (r2) {
                return JsonResult.succeed("取消点赞成功");
            }
            return JsonResult.succeed("取消点赞失败");
        }
        Favour f = new Favour();
        f.setTopic(id);
        f.setUser(user);
        if (iFavourService.save(f)) {
            return JsonResult.succeed("点赞成功");
        }
        return JsonResult.succeed("点赞失败");
    }

    //取消点赞
    @GetMapping("cancelfavour")
    public JsonResult cancelfavour(String id,String user){
        boolean r = iFavourService.remove(new QueryWrapper<Favour>().eq("topic", id).eq("user", user));
        if (r) {
            return JsonResult.succeed("取消点赞成功");
        }
        return JsonResult.succeed("取消点赞失败");
    }

}
