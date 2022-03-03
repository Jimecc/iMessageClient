package com.jim.view.controller;

import com.jim.IMessageApplication;
import com.jim.service.MoveService;
import com.jim.service.ThreadService;
import com.jim.view.view.LoginView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.GUIState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

@Slf4j
@FXMLController
public class ChatViewController {

    public ListView listView_friends;
    public ListView listView_chatMessage;
    public Label labelM1;
    public Label labelM2;

    @Autowired
    private MoveService moveService;

    @Autowired
    private ThreadService threadService;

    public void onMouseClicked_buttonLayout() {
        GUIState.getStage().setWidth(500);
        GUIState.getStage().setHeight(380);
        GUIState.getStage().centerOnScreen();
        IMessageApplication.showView(LoginView.class);
    }

    public void onMouseClicked_buttonTest(){
        Random random = new Random();
        URL cssurl = this.getClass().getClassLoader().getResource("css/lvMess.css");
        listView_chatMessage.getStylesheets().add(cssurl.toExternalForm());
        ObservableList<Pane> strList = FXCollections.observableArrayList();
        ImageView imageView = null;
        Label label_Nick = null;
//        for() {
            Label label_Mess = new Label("你好啊猫");

            label_Mess.setTextFill(Paint.valueOf(String.valueOf(Color.GRAY)));

            Pane pan = new Pane();
            if( random.nextInt(10)%3 == 0 ) {
                label_Nick = new Label("猪猪侠");

                imageView = new ImageView(new Image("file:src/main/resources/img/jpgAvatar/1.jpg"));
                label_Mess.setText("你好啊猫");
                label_Mess.setLayoutX(500-label_Mess.getPrefWidth()); // x
                label_Mess.setLayoutY(29);
                label_Mess.setFont(Font.font(12));
                imageView.setLayoutX(550);  // x
                imageView.setLayoutY(7);
                imageView.setFitHeight(40);
                imageView.setFitWidth(40);
                System.out.println(strList.toArray().length);
                label_Nick.setLayoutX(500-label_Nick.getPrefWidth());  // x
                label_Nick.setLayoutY(8);
                label_Nick.setFont(Font.font(16));
                pan.getChildren().addAll(label_Mess,label_Nick,imageView);
                strList.add(pan);
            }else{
                label_Nick = new Label("我是龙猫");
                label_Mess.setText("你好啊猪猪侠！");

                imageView = new ImageView(new Image("file:src/main/resources/img/jpgAvatar/2.jpg"));
                label_Mess.setLayoutX(55);
                label_Mess.setLayoutY(29);
                label_Mess.setFont(Font.font(12));
                imageView.setLayoutX(7);
                imageView.setLayoutY(7);
                imageView.setFitHeight(40);
                imageView.setFitWidth(40);
                System.out.println(strList.toArray().length);
                label_Nick.setLayoutX(55);
                label_Nick.setLayoutY(8);
                label_Nick.setFont(Font.font(16));
                pan.getChildren().addAll(label_Mess,label_Nick,imageView);
                strList.add(pan);
            }


//        }
        listView_chatMessage.getItems().addAll(strList);

    }
//        strList.add(u2);
//        strList.add(u3);
//        strList.add(u4);
//        strList.add(u5);
//        ListView<String> listView = new ListView<>(strList);
//        listView.setItems(strList);
//        listView.setPrefSize(400, 200);
//        moveService.move(labelM1.getLayoutX()-30,labelM1.getLayoutX()-30,labelM1.getLayoutY()-180,labelM1.getLayoutY()-230,3,labelM1);
//        labelM1.setLayoutY(labelM1.getLayoutY()-50);
//        log.info("LayoutX1:"+labelM1.getLayoutX()+"LayoutY1:"+labelM1.getLayoutY());
//        moveService.move(labelM2.getLayoutX()-490,labelM2.getLayoutX()-490,labelM2.getLayoutY()-250,labelM2.getLayoutY()-300,3,labelM2);
//        labelM1.setLayoutY(labelM1.getLayoutY()-50);
//        labelM2.setLayoutY(labelM2.getLayoutY()-50);
//
//        log.info("LayoutX2:"+labelM2.getLayoutX()+"LayoutY2:"+labelM2.getLayoutY());



    public void onMouseClicked_addFriend() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/AddFriends.fxml"));
        Parent root = loader.load();
        AddFriendsController controller = new AddFriendsController();
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("添加好友");
        stage.setScene(scene);
        stage.setResizable(false); /* 设置窗口不可改变 */
        stage.setAlwaysOnTop(true);//      窗口置顶
        stage.show();
    }

    public void initialize() {
        System.out.println("开始加载好友");
        threadService.threadRecentlyChat(listView_friends);
        System.out.println("加载好友结束");
    }
    public ChatViewController() {
    }
}

