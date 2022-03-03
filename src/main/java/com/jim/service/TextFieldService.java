package com.jim.service;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface TextFieldService {
    public void errorTextField(TextField textField, Label label, String info);
    public void commonTextField(TextField textField, Label label);
}
