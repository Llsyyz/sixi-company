package com.xmzoda.systemmanage.controller;

import com.xmzoda.systemmanage.common.Result;
import com.xmzoda.systemmanage.request.FileRequest;
import com.xmzoda.systemmanage.util.FileReaderUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
public class FileController {
    @PostMapping("/readCSV")
    public Result readCsv(@RequestBody FileRequest fileRequest) {
        String filename = "\\\\Desktop-07kteim\\共享文档-IT01\\sixi\\拼多多\\1-订单明细\\2025-02-01-2025-02-28";

        String content = FileReaderUtil.readFileSafely(filename, "utf-8", "文件读取失败");
        return Result.success(filename);
    }
}