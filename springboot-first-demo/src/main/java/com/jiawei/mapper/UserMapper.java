package com.jiawei.mapper;

import com.jiawei.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "user")
public interface UserMapper {
    @Cacheable
    User getUserById(String id);

    List<User> getUserList();

    int add(User user);

    int update(@Param("id") Integer id, @Param("user") User user);

    int delete(Integer id);
}