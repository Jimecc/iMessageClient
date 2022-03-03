package com.jim.view.handle.impl;

import com.jim.view.handle.ButtonHandle;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class ButtonHandleImpl implements ButtonHandle {
    @Override
    public void bg(Button button, String color) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf(color), new CornerRadii(5), new Insets(1))));

    }
}
