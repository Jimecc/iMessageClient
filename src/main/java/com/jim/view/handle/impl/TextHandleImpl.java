package com.jim.view.handle.impl;

import com.jim.view.handle.TextHandle;
import javafx.scene.control.TextField;


public class TextHandleImpl implements TextHandle {
    @Override
    public boolean checkOK(TextField textField,String a) {
        return true;
    }
}
