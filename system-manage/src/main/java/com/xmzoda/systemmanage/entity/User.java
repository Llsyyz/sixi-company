package com.xmzoda.systemmanage.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    // 添加 phone 字段
    private String phone;
    // 其他用户字段...
}