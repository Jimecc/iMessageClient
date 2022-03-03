package com.jim.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hsk")
public class LoginController {

    @PostMapping(value = "/login")
    public String Login(@RequestBody JSONObject jsonObject) {
        return null;
    }

}
