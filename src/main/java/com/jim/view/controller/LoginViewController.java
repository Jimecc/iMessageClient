package com.jim.view.controller;


import com.jim.entity.MyInfo;
import com.jim.entity.User;
import com.jim.service.JumpService;
import com.jim.service.TextFieldService;
import com.jim.service.PostService;
import com.jim.view.handle.ButtonHandle;
import com.jim.view.handle.impl.ButtonHandleImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@FXMLController
public class LoginViewController {

    @Autowired
    private JumpService jumpService;

    @Autowired
    private TextFieldService errorService;

    @Autowired
    private PostService postService;
    private ButtonHandle buttonHandle = new ButtonHandleImpl();


    public Button buttonTest;
    public Button buttonLogin;
    public Button buttonRegist;
    public Button buttonForget;
    public TextField textField_username;
    public PasswordField textField_password;
    public Label labelErrorUsername;
    String colorGray = "#DCDCDC";   // Regist & Forget
    String colorBlue = "#6495ED";   // Login


    public void onMouseMoved_buttonLogin(){
        buttonHandle.bg(buttonLogin,colorBlue);
    }

    public void onMouseMoved_buttonTest(){
//        paneAvatar.setBackground();
        buttonHandle.bg(buttonTest,"#F5F5F5");
    }

    public void onMouseClicked_textFieldLogin(){
        textField_username.setBorder(null);
        labelErrorUsername.setText(null);
    }

    public void onMouseClicked_textFieldPassword(){
        textField_password.setBorder(null);
        labelErrorUsername.setText(null);
    }

    public void onMouseClicked_buttonrRegist(){
        jumpService.Regist();
    }


    public void onMouseMoved_buttonRegist(){
        buttonHandle.bg(buttonRegist,colorGray);
    }

    public void onMouseMoved_buttonForget(){
        buttonHandle.bg(buttonForget,colorGray);
    }



    public void onMouseClicked_buttonLogin(){
        String username = textField_username.getText();
        String password = textField_password.getText();

        if("".equals(username)){
            errorService.errorTextField(textField_username,labelErrorUsername,"用户名或密码不能为空");
            return;
        }

        if("".equals(password)){
            errorService.errorTextField(textField_password,labelErrorUsername,"用户名或密码不能为空");
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        log.info("向后端发起登录请求");
        String a = postService.PostUser(user,"Login");
        System.out.println(a);
        if("Success".equals(a)){
            log.info("--------------登录成功！！！-------------------");
            jumpService.Chat();
        }else{
            errorService.errorTextField(textField_username,labelErrorUsername,"");
            errorService.errorTextField(textField_password,labelErrorUsername,"用户名或密码错误");
        }
    }

    public void onActionUsername(){
        onMouseClicked_buttonLogin();
    }
    public void onActionPassword(){
        onMouseClicked_buttonLogin();
    }

}
