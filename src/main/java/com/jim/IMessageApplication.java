package com.jim;

import com.jim.view.view.AddFriendsView;
import com.jim.view.view.ChatView;
import com.jim.view.view.InsertUserView;
import com.jim.view.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class IMessageApplication extends AbstractJavaFxApplicationSupport {


////    登录
//    public static void main(String[] args) {
//        launch(IMessageApplication.class, LoginView.class,new SplashScreen(){
//            public boolean visible() { return false; }
//        }, args);
//    }

    // 注册
//    public static void main(String[] args) {
//        launch(IMessageApplication.class, InsertUserView.class,new SplashScreen(){
//            public boolean visible() { return false; }
//        }, args);
//    }

      // 添加好友
//    public static void main(String[] args) {
//        launch(IMessageApplication.class, AddFriendsView.class,new SplashScreen(){
//            public boolean visible() { return false; }
//        }, args);
//    }

    // 聊天界面
    public static void main(String[] args) {
        launch(IMessageApplication.class, ChatView.class,new SplashScreen(){
            public boolean visible() { return false; }
        }, args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setResizable(false); /* 设置窗口不可改变 */
//        stage.setAlwaysOnTop(true);//      窗口置顶
        stage.getIcons().add(new Image("/img/avatar.JPG"));

//      stage.initStyle(StageStyle.TRANSPARENT); /* 透明标题栏 */

    }
}
