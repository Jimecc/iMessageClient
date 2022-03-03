package com.jim.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jim.entity.User;
import com.jim.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${ServerAddress}")
    private String ServerAddress;
    @Value("${LoginPort}")
    private String LoginPort;
    @Value("${RegistPort}")
    private String RegistPort;
    @Value("${checkUsernamePort}")
    private String checkUsernamePort;



    @Value("${PostJSON}")
    private String PostJSON;

    @Value("${AddFriend}")
    private String AddFriend;


    @Override
    public User addFriend(String username){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        System.out.println("json------"+jsonObject);
        try {
            ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8081/sys/addfriend", jsonObject, User.class);
            User user = responseEntity.getBody();
            return   user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean Login(String username,String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("User", user);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(ServerAddress + LoginPort, jsonObject, String.class);
            log.info("返回信息"+responseEntity);
            if("Success".equals(responseEntity.getBody())){
                return true;
            }
        } catch (RestClientException e) {
            log.error("解析错误，格式不正确。"+e);
            return false;

        }
        return false;
    }


    /**
     * Login  注册
     * Delete 删除
     * Find   查找
     * Insert 注册
     * @param user
     * @param status
     * @return
     */
    @Override
    public String PostUser(User user,String status) { // "Delete".equals(删除) // Login // checkUsername
        String url = ServerAddress + PostJSON;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("User", user);
            jsonObject.put("Status",status);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, jsonObject, String.class);
            log.info("返回信息"+responseEntity);
            return responseEntity.getBody();
        } catch (RestClientException e) {
            log.error("解析错误，格式不正确。"+e);
            return "Error";

        }
    }
}
