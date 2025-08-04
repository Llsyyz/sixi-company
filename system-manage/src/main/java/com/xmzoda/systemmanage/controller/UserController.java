package com.xmzoda.systemmanage.controller;

import com.xmzoda.systemmanage.common.Result;
import com.xmzoda.systemmanage.entity.User;
import com.xmzoda.systemmanage.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping()
    public User getUserByUsername(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/all")
    public Result getAllUsers() {
        return Result.success(userService.findAll().toString());
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        // 检查用户名是否已存在
        if (userService.findByUsername(user.getUsername()) != null) {
            return "用户名已存在";
        }
        userService.save(user);
        return "用户新增成功";
    }

    @PutMapping()
    public Result updateUser(String username, @RequestBody User user) {
        userService.update(username, user);
        return Result.success(null);
    }

    @DeleteMapping()
    public Result deleteUser(String username) {
        userService.delete(username);
        return Result.success(null);
    }
}