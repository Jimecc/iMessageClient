package com.jim.service;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public interface MoveService {

    public void move(double fromX, double endX, double fromY, double endY, int time, Label label) ;
}
