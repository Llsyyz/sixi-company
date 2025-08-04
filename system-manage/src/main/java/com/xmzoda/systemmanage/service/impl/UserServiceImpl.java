package com.xmzoda.systemmanage.service.impl;

import com.xmzoda.systemmanage.common.Result;
import com.xmzoda.systemmanage.entity.User;
import com.xmzoda.systemmanage.mapper.UserMapper;
import com.xmzoda.systemmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(String username, User user) {
        userMapper.update(username, user);
    }

    @Override
    public void delete(String username) {
        userMapper.delete(username);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}