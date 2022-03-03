package com.jim.mapper;

import com.jim.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    public int insertUser(User user);
    public User getUserByUsername(String username);
}