package com.jim.service;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import org.springframework.scheduling.annotation.Async;

public interface ThreadService {

    // 异步：处理最近联系人线程（微信聊天窗口左侧列表）
    public void threadRecentlyChat(ListView listView);
}
