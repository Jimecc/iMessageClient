package com.jim.service;

import com.jim.IMessageApplication;
import com.jim.view.view.ChatView;
import com.jim.view.view.InsertUserView;
import com.jim.view.view.LoginView;
import de.felixroske.jfxsupport.GUIState;

public interface JumpService {
    public void Login();
    public void Chat();
    public void Regist();
    public void AddFriend();
}
