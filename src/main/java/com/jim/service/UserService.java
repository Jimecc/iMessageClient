package com.jim.service;


import com.jim.entity.User;

public interface UserService {
    public boolean insertUser(User user);
    public User getUserByUsername(String Username);
}
