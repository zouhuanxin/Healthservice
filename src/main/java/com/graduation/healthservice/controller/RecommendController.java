package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.RecommendActivity;
import com.graduation.healthservice.service.IRecommendActivityService;
import com.graduation.healthservice.service.IRecommendFoodService;
import com.graduation.healthservice.service.IRecommendGoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 推荐控制器
 */
@RestController
@RequestMapping("/health/RecommendController")
public class RecommendController {
    @Resource
    IRecommendActivityService iRecommendActivityService;
    @Resource
    IRecommendFoodService iRecommendFoodService;
    @Resource
    IRecommendGoodsService iRecommendGoodsService;

    /**
     * 活动推荐
     */
    @GetMapping("recommendActivity")
    public JsonResult recommendActivity(){
        List<RecommendActivity> r = iRecommendActivityService.list(new QueryWrapper<RecommendActivity>().eq("state",true));
        return JsonResult.succeed("查询成功",r);
    }

    /**
     * 食物推荐
     */
    @GetMapping("recommendFood")
    public JsonResult recommendFood(){
        return JsonResult.succeed("查询成功",iRecommendFoodService.list());
    }

    /**
     * 活动推荐
     */
    @GetMapping("recommendGoods")
    public JsonResult recommendGoods(){
        return JsonResult.succeed("查询成功",iRecommendGoodsService.list());
    }


}
