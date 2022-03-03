package com.jim.view.controller;


import com.jim.entity.User;
import com.jim.service.PostService;
import com.jim.service.impl.PostServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
@FXMLController
public class AddFriendsController {

    @Autowired
    PostService postService;

    public Button buttonClear;
    public Pane paneShadow;
    public Label label_nickname;
    public Label label_username;
    public Label label_info;
    public Label label_error;
    public ImageView image_avatar;
    public Pane pane_userinfo;


    public TextField textField_username;
    public void Action_findFriend(){
        pane_userinfo.setOpacity(0);
        label_error.setText(null);

        PostService po = new PostServiceImpl();
        try {
            User user = po.addFriend(textField_username.getText()); // NULL or User user
            if(user==null){
                label_error.setText("查找失败,该用户不存在.");
            }else{
                DropShadow dropShadow = new DropShadow();
                dropShadow.setRadius(8);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(3);
                dropShadow.setSpread(0.4);
                dropShadow.setColor(Color.DARKGRAY);
                paneShadow.setEffect(dropShadow);
                pane_userinfo.setOpacity(1);
                image_avatar.setImage(new Image("file:/Users/hsk/Documents/DevDocument/mySELF/iMessage/src/main/resources/img/avatar.JPG"));

                label_nickname.setText(user.getNickname());
                label_username.setText("账号："+user.getUsername());
                label_info.setText("简介："+user.getInfo());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void onMouseClicked_textFieldUsersername(){
        pane_userinfo.setOpacity(0);
        label_error.setText(null);
    }

    public void onKeyTyped_textField_username(){

    }
    public void onMouseMoved_buttonClear(){
        Background bg = new Background(new BackgroundFill(Paint.valueOf("#f6f8fa"), new CornerRadii(5), new Insets(1)));
        buttonClear.setBackground(bg);
    }

    public void onMouseClicked_buttonClear(){
        textField_username.setText(null);
    }

}
