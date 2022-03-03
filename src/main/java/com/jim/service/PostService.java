package com.jim.service;

import com.jim.entity.User;

public interface PostService {
    public User addFriend(String username);
    public boolean Login(String username,String password);
    public String PostUser(User user, String status);
}
