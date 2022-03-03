package com.jim.entity;

import lombok.Data;

@Data
public  class MyInfo {
    private String nickname;
    private String username;
    private String info;

    public void setMyInfo(String nickename, String username, String info){
        this.nickname = nickename;
        this.username = username;
        this.info = info;
    }

}
