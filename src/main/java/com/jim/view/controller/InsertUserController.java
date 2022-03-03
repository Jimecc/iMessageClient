package com.jim.view.controller;

import com.jim.entity.User;
import com.jim.service.JumpService;
import com.jim.service.TextFieldService;
import com.jim.service.PostService;
import com.jim.service.UserService;
import com.jim.view.handle.PasswordUtil;
import com.jim.view.handle.TextHandle;
import com.jim.view.handle.impl.TextHandleImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@FXMLController
public class InsertUserController {


    @Autowired
    private PostService postService;

    @Autowired
    private TextFieldService textFieldService;

    @Autowired
    private UserService userService;

    @Autowired
    private JumpService jumpService;

    public TextField textField1;
    public TextField textField2;
    public TextField textField3;
    public TextField textField4;
    public TextField textField5;
    public TextField textField6;
    public Label label_nickname;
    public Label label_username;
    public Label label_password;
    public Label label_repassword;
    public Label label_info;
    public Label label_mail;
    public Label label_registSuccess;
    public Label label_registFailed;



    public void onMouseClicked_submit(){


        TextHandle textHandle = new TextHandleImpl();
        Date date=new Date();//此时date为当前的时间
        System.out.println(date);
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");//设置当前时间的格式，为年-月-日


        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;


        User user = new User();
        String nickname = textField1.getText();
        String username = textField2.getText();
        String pwd      = textField3.getText();
        String repwd    = textField4.getText();
        String info     = textField5.getText();
        String mail     = textField6.getText();



        if(!"".equals(nickname)) {
            user.setNickname(nickname);
            b1 = true;
        }else{
            textFieldService.errorTextField(textField1,label_nickname,"昵称不可为空");
        }

        if("".equals(username)) {
            textFieldService.errorTextField(textField2,label_username,"用户名不可为空");
        }else{
            user.setUsername(username);
            if("Existed".equals(postService.PostUser(user,"checkUsername"))) {
                textFieldService.errorTextField(textField2, label_username, "该用户名已被注册");
                user.setUsername(null);
            }else{
                b2 = true;
            }
        }


        if("".equals(pwd) || "".equals(repwd)) {
            textFieldService.errorTextField(textField3,label_password,"请输入密码并确认密码");
            textFieldService.errorTextField(textField4,label_repassword,"请输入密码并确认密码");
        }else if(!pwd.equals(repwd)){
            textFieldService.errorTextField(textField3,label_password,"两次密码不一致，请检查后重新输入。");
            textFieldService.errorTextField(textField4,label_repassword,"两次密码不一致，请检查后重新输入。");
        }else {
            b3 = true;
            user.setPassword(textField3.getText());
            b4 = true;
        }

        if(!"".equals(info)) {
            user.setInfo(info);
        }else{
            user.setInfo("新用户"+ PasswordUtil.randomNum(8));
        }

        user.setMail(mail);
        user.setCreatetime(dateFormat.format(date));
        if(b1 && b2 && b3 && b4){
            try {
                if("Success".equals(postService.PostUser(user,"Regist"))){
                    label_registSuccess.setText("您已成功完成注册");
                }else{
                    label_registFailed.setText("注册失败");
                }
            }catch (Exception e){
                label_registFailed.setText("未知错误，注册失败");
            }
        }
    }

    public void onMouseClicked_buttonBack(){
        jumpService.Login();
    }

    public void onMouseClicked_buttonWeb(){
    }

    /**
     * onMouseClicked ———— 鼠标点击输入框事件
     */

    public void onMouseClicked_textField1(){
        textFieldService.commonTextField(textField1,label_nickname);
        SetNull();
    }
    public void onMouseClicked_textField2(){
        textFieldService.commonTextField(textField2,label_username);
        SetNull();
    }
    public void onMouseClicked_textField3(){
        textFieldService.commonTextField(textField3,label_password);
        SetNull();
    }
    public void onMouseClicked_textField4(){
        textFieldService.commonTextField(textField4,label_repassword);
        SetNull();
    }
    public void onMouseClicked_textField5(){
        textFieldService.commonTextField(textField5,label_info);
        SetNull();
    }
    public void onMouseClicked_textField6(){
        textFieldService.commonTextField(textField6,label_mail);
        SetNull();
    }

    public void SetNull(){
        label_registSuccess.setText(null);
        label_registFailed .setText(null);
    }

}
