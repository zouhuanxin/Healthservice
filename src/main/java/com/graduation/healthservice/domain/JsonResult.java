package com.graduation.healthservice.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T>  implements Serializable {

    String message;
    String token;
    int code;
    T data;


    public JsonResult() {
    }


    public JsonResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public JsonResult(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public JsonResult(String message, int code, T data,String token) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.token = token;
    }

    public JsonResult(String message, int code,String token) {
        this.message = message;
        this.code = code;
        this.token = token;
    }


    public static JsonResult succeed(String message) {
        return new JsonResult(message, 200);
    }

    public static JsonResult succeed(String message,Object data,String token) {
        return new JsonResult(message, 200,data,token);
    }

    public static JsonResult succeed(String message, Object data) {
        return new JsonResult(message, 200, data);
    }

    public static JsonResult error(String message) {
        return new JsonResult(message, 400);
    }

    public static JsonResult error(String message, Object data) {
        return new JsonResult(message, 400, data);
    }

    public static JsonResult result(String message, int code, Object data) {
        return new JsonResult(message, code, data);
    }


}
