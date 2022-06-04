package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.CalorieHistory;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.service.ICalorieHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 饮食记录控制器
 */
@RestController
@RequestMapping("/health/RecordController")
public class RecordController {
    @Resource
    ICalorieHistoryService iCalorieHistoryService;

    @PostMapping("addCalorie")
    public JsonResult addCalorie(@RequestBody  CalorieHistory record){
        System.out.println(record);
        if (record.getName() == null)  return JsonResult.error("菜品名称不能为空");
        if (record.getCalorie() == null)  return JsonResult.error("菜品卡路里不能为空");
        if (record.getUser() == null)  return JsonResult.error("用户不能为空");
        if (record.getUrl() == null)  return JsonResult.error("菜品图片不能为空");
        if (record.getHref() == null)  return JsonResult.error("菜品链接不能为空");
        //添加时间
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        record.setCreatedtime(date.format(formatter));
        if (iCalorieHistoryService.save(record)){
            return JsonResult.succeed("添加成功",record);
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 根据用户名来获取所有饮食记录
     */
    @GetMapping("byUserData")
    public JsonResult byUserData(String user){
        List<CalorieHistory> list = iCalorieHistoryService.list(new QueryWrapper<CalorieHistory>().eq("user",user));
        return JsonResult.succeed("查询成功",list);
    }

    /**
     * 根据用户名以及饮食日期来获取所有饮食记录
     */
    @GetMapping("byUserAndTimeData")
    public JsonResult byUserAndTimeData(String user,String time){
        List<CalorieHistory> list = iCalorieHistoryService.list(new QueryWrapper<CalorieHistory>().eq("user",user).eq("createdtime",time));
        System.out.println(list);
        return JsonResult.succeed("查询成功",list);
    }

}
