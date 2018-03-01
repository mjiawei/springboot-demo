package com.jiawei.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiawei.bean.User;
import com.jiawei.mapper.UserMapper;
import com.jiawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public User getUserById(String id) {
        Jedis jedis = jedisPool.getResource();
        String uuid1 = jedis.get("uuid");
        if (StringUtils.isEmpty(uuid1)) {
            uuid1 = UUID.randomUUID().toString();
            jedis.setex("uuid",5,uuid1);
        } else {
            System.err.println("redis==========================>>>"+uuid1);
        }
        jedis.close();
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userMapper.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
