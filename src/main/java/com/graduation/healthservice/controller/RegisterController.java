package com.graduation.healthservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.graduation.healthservice.domain.JsonResult;
import com.graduation.healthservice.domain.Register;
import com.graduation.healthservice.domain.Userinfo;
import com.graduation.healthservice.service.IRegisterService;
import com.graduation.healthservice.service.IUserinfoService;
import com.graduation.healthservice.tools.RedisUtils;
import lombok.val;
import okhttp3.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.concurrent.Future;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.*;

@RestController
@RequestMapping("/health/register")
public class RegisterController {
    @Resource
    private IRegisterService iRegisterService;

    @Resource
    private IUserinfoService iUserinfoService;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 测试
     */
    @GetMapping("test")
    public JsonResult test() {
        return JsonResult.succeed("测试成功");
    }

    /**
     * 用户注册
     */
    @PostMapping("register")
    public JsonResult register(@RequestBody Register register) {
        if (register.getPhone() == null) return JsonResult.error("手机号不能为空");
        //账号默认为手机号
        if (register.getAccount() == null) register.setAccount(register.getPhone());
        //默认创建一条userinfo表信息
        Userinfo userinfo = new Userinfo();
        userinfo.setPhone(register.getPhone());
        userinfo.setUsername(register.getPhone()); //注册时默认的用户名就是手机号
        userinfo.setPortrait("https://img0.baidu.com/it/u=3965464646,1730750347&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"); //默认头像
        if (iRegisterService.save(register) && iUserinfoService.save(userinfo)) {
            return JsonResult.succeed("注册成功");
        } else {
            return JsonResult.error("注册失败");
        }
    }

    /**
     * 用户登陆
     */
    @PostMapping("login")
    public JsonResult login(@RequestBody Register register) {
        System.out.println("登陆:"+register);
        if (register.getPhone() == null) return JsonResult.error("手机号不能为空");
        if (register.getPassword() == null) return JsonResult.error("密码不能为空");
        if (iRegisterService.getOne(new QueryWrapper<Register>().eq("phone", register.getPhone()).eq("password", register.getPassword())) != null) {
            Userinfo userinfo = iUserinfoService.getOne(new QueryWrapper<Userinfo>().eq("phone", register.getPhone()));
            if (userinfo == null) userinfo = new Userinfo();
            String token = UUID.randomUUID().toString();
            redisUtils.set(token, userinfo.getPhone());
            System.out.println("登陆成功:"+userinfo);
            return JsonResult.succeed("登陆成功", userinfo, token);
        }
        System.out.println("登陆失败");
        return JsonResult.error("登陆失败");
    }

    /**
     * 设置用户信息
     */
    @PostMapping("updateUserinfo")
    public JsonResult updateUserinfo(@RequestBody Userinfo userinfo){
        System.out.println(userinfo);
        if (userinfo.getPhone() == null) return JsonResult.error("手机号不能为空");
        boolean r = iUserinfoService.update(userinfo,new QueryWrapper<Userinfo>().eq("phone",userinfo.getPhone()));
        if (r){
            return JsonResult.succeed("更新成功");
        }
        return JsonResult.error("更新失败");
    }

    /**
     * 禁止用户登陆
     * 管理员
     */


    /**
     * 解除用户登陆禁止
     * 管理员
     */


    /**
     * 发送短信
     */

    @PostMapping("sendsms")
    public Future<JsonResult> sendSMS(@RequestBody Register register) {
        System.out.println(register);
        return send(register.getPhone());
    }

    @Async
    Future<JsonResult> send(String mobilePhoneNumber) {
        if (mobilePhoneNumber == null) return new AsyncResult(JsonResult.error("请输入手机号"));
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        JSONObject req = new JSONObject();
        req.put("mobilePhoneNumber", mobilePhoneNumber);
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(JSON, req.toJSONString());
        okhttp3.Request request = new Request.Builder()
                .url("https://api2.bmob.cn/1/requestSmsCode")
                .header("Content-Type","application/json; charset=utf-8")
                .header("X-Bmob-Application-Id", "931aa07205e9cddf2cd85458d029af79")
                .header("X-Bmob-REST-API-Key", "9e1c0370c480f4c47053d155b6d3b251")
                .post(requestBody)
                .build();
        Call call = new OkHttpClient().newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
            if (response.code() == 200) {
                return new AsyncResult(JsonResult.succeed("发送成功"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("发送失败"));
    }

    /**
     * 短信验证
     */
    @PostMapping("verify")
    public Future<JsonResult> verifyCode(@RequestBody Register register) {
        //account字段暂时代替code字段使用
        System.out.println(register);
        return verify(register.getPhone(), register.getAccount());
    }

    @Async
    Future<JsonResult> verify(String mobilePhoneNumber, String smsCode) {
        if (mobilePhoneNumber == null) return new AsyncResult(JsonResult.error("请输入手机号"));
        if (smsCode == null) return new AsyncResult(JsonResult.error("请输入验证码"));
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        JSONObject req = new JSONObject();
        req.put("mobilePhoneNumber", mobilePhoneNumber);
        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(JSON, req.toJSONString());
        okhttp3.Request request = new Request.Builder()
                .url("https://api2.bmob.cn/1/verifySmsCode/"+smsCode)
                .header("X-Bmob-Application-Id", "931aa07205e9cddf2cd85458d029af79")
                .header("X-Bmob-REST-API-Key", "9e1c0370c480f4c47053d155b6d3b251")
                .post(requestBody)
                .build();
        Call call = new OkHttpClient().newCall(request);
        okhttp3.Response res = null;
        try {
            res = call.execute();
            if (res.code() == 200 && JSONObject.parseObject(res.body().string()).getString("msg").equals("ok")) {
                Userinfo userinfo = iUserinfoService.getOne(new QueryWrapper<Userinfo>().eq("phone", mobilePhoneNumber));
                if (userinfo == null) userinfo = new Userinfo();
                val token = UUID.randomUUID().toString();
                redisUtils.set(token, userinfo.getPhone());
                return new AsyncResult(JsonResult.succeed("登陆成功", userinfo, token));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("验证失败"));
    }

    /**
     * 返回所有普通用户信息
     */
    @GetMapping("getAllUserInfo")
    public JsonResult getAllUserInfo(){
        return JsonResult.succeed("查询成功",iUserinfoService.list());
    }
}
