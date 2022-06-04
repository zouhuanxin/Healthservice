package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.LaunchPageAdvertisement;
import com.graduation.healthservice.service.ILaunchPageAdvertisementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/health/advertisement")
public class LaunchAdvertisementController {

    @Resource
    private ILaunchPageAdvertisementService iLaunchPageAdvertisementService;

    /**
     * 获取所有广告数据
     */
    @GetMapping("getAllAdvertisement")
    public JsonResult getAllAdvertisement(){
        return JsonResult.succeed("查询成功",iLaunchPageAdvertisementService.list());
    }

    /**
     * 获取所有有效广告数据
     */
    @GetMapping("getEffectiveAd")
    public JsonResult getEffectiveAd(){
        return JsonResult.succeed("查询成功",iLaunchPageAdvertisementService.list(new QueryWrapper<LaunchPageAdvertisement>().eq("isable",true)));
    }

}
