package com.graduation.healthservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.PunchCard;
import com.graduation.healthservice.mapper.PunchCardMapper;
import com.graduation.healthservice.service.IPunchCardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 打卡控制器
 */
@RestController
@RequestMapping("/health/PunchCardController")
public class PunchCardController {
    @Resource
    IPunchCardService iPunchCardService;
    @Resource
    PunchCardMapper punchCardMapper;

    /**
     * 添加一个打卡
     */
    @PostMapping("addPunchCard")
    public JsonResult addPunchCard(@RequestBody PunchCard punchCard) {
        boolean r = iPunchCardService.save(punchCard);
        if (r) {
            return JsonResult.succeed("添加成功");
        }
        return JsonResult.succeed("添加失败");
    }

    /**
     * 查询当前用户的打卡信息
     * day: yyyy-MM-dd
     */
    @GetMapping("getPunchCard")
    public JsonResult getPunchCard(String phone) {
        System.out.println(phone);
        List<PunchCard> r = iPunchCardService.list(new QueryWrapper<PunchCard>().eq("user", phone));
        System.out.println(r);
        return JsonResult.succeed("查询成功", r);
    }

    /**
     * 获取当前用户的打卡排名
     */
    @GetMapping("getPunchCardRank")
    public JsonResult getPunchCardRank(String phone) {
        System.out.println(phone);
        List<PunchCard> r = punchCardMapper.getPunchCardRank();
//        int index = 0;
//        for (int i = 0; i < r.size(); i++) {
//            index++;
//            if (r.get(i).getUser().equals(phone)) {
//                return JsonResult.succeed("查询失败", index);
//            }
//        }
        return JsonResult.succeed("查询成功",r);
    }

}
