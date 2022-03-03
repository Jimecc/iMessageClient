package com.jim.service.impl;

import com.jim.service.MoveService;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {
    @Override
    public void move(double fromX, double endX, double fromY, double endY, int time, Label label) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time * 100), label);
        translateTransition.setFromX(fromX);
        translateTransition.setToX(endX);
        translateTransition.setFromY(fromY);
        translateTransition.setToY(endY);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();//启动动画
    }
}
