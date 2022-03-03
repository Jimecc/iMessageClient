package com.jim.service.impl;



import com.jim.service.ThreadService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@Component
@Slf4j
@RestController
@Service
public class ThreadServiceImpl implements ThreadService {

    @Override
    @Async("ThreadRecentChat")
    public void threadRecentlyChat(ListView listView) {
        URL cssurl = this.getClass().getClassLoader().getResource("css/lvRecentChat.css");
        listView.getStylesheets().add(cssurl.toExternalForm());
        ObservableList<Pane> paneList = FXCollections.observableArrayList();


        for(int i=0;i<10;i++) {
            Pane pan = new Pane();
            Label label_Nick = new Label("我是猫"+i);
            Label label_Mess = new Label("你好啊猫");
            ImageView imageView = new ImageView(new Image("file:src/main/resources/img/jpgAvatar/"+(i%9+1)+".jpg"));
            imageView.setLayoutX(7);
            imageView.setLayoutY(7);
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);


            System.out.println(paneList.toArray().length);
            label_Nick.setLayoutX(55);
            label_Nick.setLayoutY(8);
            label_Nick.setFont(Font.font(16));

            label_Mess.setLayoutX(55);
            label_Mess.setLayoutY(29);
            label_Mess.setFont(Font.font(12));

            label_Mess.setTextFill(Paint.valueOf(String.valueOf(Color.GRAY)));

            pan.getChildren().addAll(label_Mess,label_Nick,imageView);
            paneList.add(pan);

        }
        listView.getItems().addAll(paneList);

    }

}
