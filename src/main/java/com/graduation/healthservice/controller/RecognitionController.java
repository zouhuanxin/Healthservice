package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.CalorieHistory;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.service.ICalorieHistoryService;
import com.graduation.healthservice.tools.Dish;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 菜品识别控制器
 * 1，图片识别
 * 2，文字识别
 *
 * 返回图片信息和菜品信息
 * 并且添加一条识别记录
 */

@RestController
@RequestMapping("/health/RecognitionController")
public class RecognitionController {
    @Resource
    ICalorieHistoryService iCalorieHistoryService;

    //图片识别
    @GetMapping("dish")
    Future<JsonResult> dish(String url){
        return Dish.advancedGeneral(url);
    }

    //文字查询
    @GetMapping("dishText")
    Future<JsonResult> dishText(String name){
        return Dish.dishText(name);
    }


    /**
     * 营养分析
     * 根据用户手机号分析用户当天的一个饮食营养情况
     * 主要因素有
     * 1。热量(大卡) 女性1800～1900，男性1980～2340
     * 2。碳水化合物(克) 130克
     * 3。脂肪(克) 300g
     * 4。蛋白质(克) 75g
     * 5。纤维素(克) 30g
     * 以上5个维度去分析
     */
    @GetMapping("analysis")
    Future<JsonResult> analysis(String phone){
        List<CalorieHistory> list = iCalorieHistoryService.list(new QueryWrapper<CalorieHistory>().eq("user",phone));
        return Dish.NutritionAnalysis(list);
    }

    /**
     * 返回所有卡路里信息
     */
    @GetMapping("getAllCalorie")
    public JsonResult getAllCalorie(){
        return JsonResult.succeed("查询成功",iCalorieHistoryService.list());
    }

}
