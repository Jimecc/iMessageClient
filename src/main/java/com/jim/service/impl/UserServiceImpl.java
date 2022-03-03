package com.jim.service.impl;


import com.jim.entity.User;
import com.jim.mapper.UserMapper;
import com.jim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user) > 0 ? true : false;
    }

    @Override
    public User getUserByUsername(String Username) {
        return userMapper.getUserByUsername(Username);
    }
}