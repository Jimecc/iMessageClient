package com.jim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 id	        int		 🤦‍♀️	✅	🔑
 nickname	varchar	255				 最长 15 / 允许包含正常符号
 username	varchar	255				 最长 25 / 没有特殊符号
 password	varchar	255				 最长 25 / 允许包含正常符号
 salt	varchar	255				盐
 mail	varchar	255				邮箱
 avatar	varchar	300				一个 url / 图片ID长度应不超过 10 username+图片 ID
 info	varchar	255				个人简介 可以是 Null...
 createtime	datetime
 statue	varchar	25				online / offline

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String nickname;
    private String username;
    private String password;
    private String salt;
    private String mail;
    private String avatar;
    private String info;
    private String statue;
    private String createtime;

}
