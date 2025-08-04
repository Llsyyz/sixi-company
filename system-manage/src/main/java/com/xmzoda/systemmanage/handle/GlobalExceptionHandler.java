package com.xmzoda.systemmanage.handle;

import com.xmzoda.systemmanage.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有Exception类型异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(500, "服务器内部错误: " + e.getMessage());
    }

}