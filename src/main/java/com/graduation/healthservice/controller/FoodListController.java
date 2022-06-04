package com.graduation.healthservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.Foodlist;
import com.graduation.healthservice.domain.FoodlistFavour;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.service.IFoodlistFavourService;
import com.graduation.healthservice.service.IFoodlistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 人气食谱
 */
@RestController
@RequestMapping("/health/FoodListController")
public class FoodListController {
    @Resource
    IFoodlistFavourService iFoodlistFavourService;
    @Resource
    IFoodlistService iFoodlistService;

    /**
     * 查询所有人气食谱信息
     */
    @GetMapping("getFoodListData")
    public JsonResult getFoodListData() {
        return JsonResult.succeed("查询成功", iFoodlistService.list());
    }

    /**
     * 根据手机号获取自己喜欢的食谱
     * ！！！这里应该要做个视图表处理，为了省时间这里不做了，直接代码中for循环解决了
     */
    @GetMapping("byUserFoodlist")
    public JsonResult byUserFoodlist(String phone) {
        List<FoodlistFavour> list1 = iFoodlistFavourService.list(new QueryWrapper<FoodlistFavour>().eq("user", phone));
        JSONArray array = new JSONArray();
        for (int i = 0; i < list1.size(); i++) {
            Foodlist foodlist = iFoodlistService.getOne(new QueryWrapper<Foodlist>().eq("id",list1.get(i).getFoodlistid()));
            JSONObject item = new JSONObject();
            item.put("id",list1.get(i).getId());
            item.put("user",list1.get(i).getUser());
            item.put("foodlistid",list1.get(i).getFoodlistid());
            item.put("name",foodlist.getName());
            item.put("introduce",foodlist.getIntroduce());
            item.put("url",foodlist.getUrl());
            item.put("image",foodlist.getImage());
            array.add(item);
        }
        return JsonResult.succeed("查询成功", array);
    }

    /**
     * 添加自己喜欢的食物
     */
    @PostMapping("addFoodlistFavour")
    public JsonResult addFoodlistFavour(@RequestBody FoodlistFavour foodlistFavour) {
        System.out.println(foodlistFavour);
        if (foodlistFavour.getUser()==null) return JsonResult.error("不能没有用户");
        if (foodlistFavour.getFoodlistid()==null) return JsonResult.error("不能没有菜谱id");

        if (iFoodlistFavourService.save(foodlistFavour)){
            return JsonResult.succeed("添加成功",foodlistFavour);
        }
        return JsonResult.error("添加失败");
    }

}
