package com.graduation.healthservice.tools;

import com.graduation.healthservice.domain.JsonResult;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

public class TextCensor {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static Future<JsonResult> TextCensor(String text) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/solution/v1/text_censor/v2/user_defined";
        try {
            String param = "text=" + text;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth2();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return new AsyncResult(JsonResult.succeed("识别成功", result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult(JsonResult.error("识别失败"));
    }


}
