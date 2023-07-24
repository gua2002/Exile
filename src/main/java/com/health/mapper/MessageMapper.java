package com.health.mapper;

import com.health.po.Message;
import com.health.po.Replay;

import java.util.List;

/**
 * @author wuyang
 * @ClassName MessageMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface MessageMapper {

    List<Message> findMessage();

    int insertMessage(Message message);

    int insertMessageCount(Replay replay);
}
