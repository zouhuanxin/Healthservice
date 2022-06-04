package com.graduation.healthservice.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.graduation.healthservice.domain.CalorieHistory;
import com.graduation.healthservice.domain.JsonResult;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.AsyncResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Dish {

    /**
     * 菜品识别
     */
    public static Future<JsonResult> dish(String imageurl) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
        try {

            String param = "url=" + imageurl + "&top_num=" + 5;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return new AsyncResult(JsonResult.succeed("识别成功", result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("识别失败"));
    }

    /**
     * 通用物品识别
     * 这个识别不会返回卡路里信息，所以这里需要根据名称去查询一下卡路里
     */
    public static Future<JsonResult> advancedGeneral(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";
        try {
            String param = "url=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            //开始获取信息
            JSONArray resArr = new JSONArray();
            JSONObject res = JSONObject.parseObject(result);
            JSONArray array = res.getJSONArray("result");
            for (int i = 0; i < array.size(); i++) {
                String name = array.getJSONObject(i).getString("keyword");
                JSONObject item = getKll(name);
                if (item != null) {
                    resArr.add(item);
                }
            }
            System.out.println(resArr);
            return new AsyncResult(JsonResult.succeed("识别成功", resArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("识别失败"));
    }

    //查询卡路里
    private static JSONObject getKll(String name) {
        okhttp3.Request request = new Request.Builder()
                .url("https://www.boohee.com/food/search?keyword=" + name)
                .get()
                .build();
        Call call = new OkHttpClient().newCall(request);
        okhttp3.Response res = null;
        try {
            res = call.execute();
            if (res.code() == 200) {
                //html解析
                return kllanalysis(res.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解析html，提取出卡路里信息
    private static JSONObject kllanalysis(String html) {
        Document document = Jsoup.parse(html);
        //拿到标签信息
        Elements items = document.getElementsByClass("item clearfix");
        //默认取第一个
        JSONObject item = new JSONObject();
        //图片
        Element img = items.get(0).getElementsByClass("img-box pull-left").get(0).getElementsByTag("img").get(0);
        item.put("image", img.attr("src"));
        //名称
        Element name = items.get(0).getElementsByClass("text-box pull-left").get(0).getElementsByTag("a").get(0);
        item.put("name", name.attr("title"));
        //描述
        Element introduce = items.get(0).getElementsByClass("text-box pull-left").get(0).getElementsByTag("p").get(0);
        item.put("introduce", introduce.text());
        //详情链接
        item.put("href", "https://www.boohee.com/" + name.attr("href"));
        return item;
    }


    /**
     * 文字识别
     */
    public static Future<JsonResult> dishText(String name) {
        okhttp3.Request request = new Request.Builder()
                .url("https://www.boohee.com/food/search?keyword=" + name)
                .get()
                .build();
        Call call = new OkHttpClient().newCall(request);
        okhttp3.Response res = null;
        try {
            res = call.execute();
            if (res.code() == 200) {
                //html解析
                return new AsyncResult(JsonResult.succeed("查询成功", analysis(res.body().string())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("识别失败"));
    }

    private static JSONArray analysis(String html) {
        Document document = Jsoup.parse(html);
        //拿到标签信息
        Elements items = document.getElementsByClass("item clearfix");
        JSONArray labels = new JSONArray();
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = new JSONObject();
            //图片
            Element img = items.get(i).getElementsByClass("img-box pull-left").get(0).getElementsByTag("img").get(0);
            item.put("image", img.attr("src"));
            //名称
            Element name = items.get(i).getElementsByClass("text-box pull-left").get(0).getElementsByTag("a").get(0);
            item.put("name", name.attr("title"));
            //描述
            Element introduce = items.get(i).getElementsByClass("text-box pull-left").get(0).getElementsByTag("p").get(0);
            item.put("introduce", introduce.text());
            //详情链接
            item.put("href", "https://www.boohee.com/" + name.attr("href"));
            labels.add(item);
        }
        System.out.println(labels);
        return labels;
    }

    /**
     * 营养分析
     */
    public static Future<JsonResult> NutritionAnalysis(List<CalorieHistory> list) {
        //查询每一个食物的5个因素
        List<JSONObject> res = new ArrayList<>();
        for (CalorieHistory ca : list) {
            res.add(NutritionAnalysisDeal(ca));
        }
        return new AsyncResult(JsonResult.succeed("查询成功",res));
    }

    //因素查询
    private static JSONObject NutritionAnalysisDeal(CalorieHistory ca) {
        JSONArray labels = new JSONArray();
        okhttp3.Request request = new Request.Builder()
                .url(ca.getHref())
                .get()
                .build();
        Call call = new OkHttpClient().newCall(request);
        okhttp3.Response res = null;
        try {
            res = call.execute();
            if (res.code() == 200) {
                //html解析
                Document document = Jsoup.parse(res.body().string());
                //拿到标签信息
                Elements items = document.getElementsByClass("nutr-tag margin10").get(0).getElementsByClass("content").get(0).getElementsByTag("dl");
                for (int i = 0; i < items.size(); i++) {
                    Elements dd = items.get(i).getElementsByTag("dd");
                    for (int j=0;j<dd.size();j++){
                        JSONObject item = new JSONObject();
                        item.put("info",dd.get(j).text());
                        labels.add(item);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        labels.remove(0);
        JSONObject item = new JSONObject();
        item.put("name",ca.getName());
        item.put("info",labels);
        return item;
    }

}
