package com.xmzoda.systemmanage.service;

import com.xmzoda.systemmanage.common.Result;
import com.xmzoda.systemmanage.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void update(String username, User user);
    void delete(String username);
    User findByUsername(String username);
}