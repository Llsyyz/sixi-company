package com.xmzoda.systemmanage.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private String data; // 将泛型类型改为String类型

    // 成功响应
    public static Result success(String data) {
        Result result = new Result();
        result.code = 200;
        result.message = "操作成功";
        result.data = data;
        return result;
    }

    // 失败响应
    public static Result error(int code, String message) {
        Result result = new Result();
        result.code = code;
        result.message = message;
        return result;
    }

    // 省略getter/setter...
}