package com.health.service;

import com.health.po.Message;
import com.health.po.Replay;

import java.util.List;

/**
 * @author wuyang
 * @ClassName MessageService
 * @Description TODO
 * @Version 1.0
 **/
public interface MessageService {

    List<Message> findMessage();

    int insertMessage(Message message);

    int insertMessageCount(Replay replay);
}
