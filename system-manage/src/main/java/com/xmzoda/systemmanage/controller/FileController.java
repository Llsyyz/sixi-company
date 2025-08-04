package com.xmzoda.systemmanage.controller;

import com.xmzoda.systemmanage.common.Result;
import com.xmzoda.systemmanage.request.FileRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
public class FileController {
    @PostMapping("/readCSV")
    public Result readCsv(@RequestBody FileRequest fileRequest) {
        return Result.success("");
    }
}