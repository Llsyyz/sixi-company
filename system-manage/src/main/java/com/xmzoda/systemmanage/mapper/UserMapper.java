package com.xmzoda.systemmanage.mapper;

import com.xmzoda.systemmanage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO user(username, password, email, phone) VALUES(#{username}, #{password}, #{email}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE user SET password=#{user.password}, email=#{user.email}, phone=#{user.phone} WHERE username=#{username}")
    void update(@Param("username") String username, @Param("user") User user);

    @Delete("DELETE FROM user WHERE username = #{username}")
    void delete(@Param("username") String username);
}