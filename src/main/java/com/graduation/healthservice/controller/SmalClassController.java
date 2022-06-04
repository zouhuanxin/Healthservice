package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.Smalclass;
import com.graduation.healthservice.service.ISmalclassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/health/SmalClassController")
public class SmalClassController {
    @Resource
    private ISmalclassService ismalclassservice;

    //获取所有小分类
    @GetMapping("getAllSmalClass")
    public JsonResult getAllSmalClass(){
        List<Smalclass> r = ismalclassservice.list(new QueryWrapper<Smalclass>().eq("islegal",true));
        return JsonResult.succeed("查询成果",r);
    }

}
