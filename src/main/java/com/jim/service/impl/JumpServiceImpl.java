package com.jim.service.impl;

import com.jim.IMessageApplication;
import com.jim.service.JumpService;
import com.jim.view.view.ChatView;
import com.jim.view.view.InsertUserView;
import com.jim.view.view.LoginView;
import de.felixroske.jfxsupport.GUIState;
import org.springframework.stereotype.Service;

@Service
public class JumpServiceImpl implements JumpService {

    @Override
    public void Login(){
        GUIState.getStage().setWidth(500);
        GUIState.getStage().setHeight(380);
        GUIState.getStage().centerOnScreen();
        IMessageApplication.showView(LoginView.class);
    }

    @Override
    public void Chat(){
        GUIState.getStage().setWidth(900);
        GUIState.getStage().setHeight(600);
//            GUIState.getStage().set
        // 将舞台置于窗口中央
        GUIState.getStage().centerOnScreen();
        IMessageApplication.showView(ChatView.class);
    }

    @Override
    public void Regist(){
        GUIState.getStage().setWidth(700);
        GUIState.getStage().setHeight(500);
        GUIState.getStage().centerOnScreen();
        IMessageApplication.showView(InsertUserView.class);
    }

    @Override
    public void AddFriend(){

    }

}
