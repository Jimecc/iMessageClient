package com.jim.service.impl;

import com.jim.service.TextFieldService;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import org.springframework.stereotype.Service;

@Service
public class TextFieldServiceImpl implements TextFieldService {
    @Override
    public void errorTextField(TextField textField, Label label, String info){
        BorderStroke bos = new BorderStroke(Paint.valueOf("#FF3000"), BorderStrokeStyle.SOLID,new CornerRadii(3), new BorderWidths((1)));
        Border bo = new Border(bos);
        textField.setBorder(bo);
        label.setText(info);
    }

    @Override
    public void commonTextField(TextField textField, Label label) {
        textField.setBorder(null);
        label.setText(null);
    }
}
