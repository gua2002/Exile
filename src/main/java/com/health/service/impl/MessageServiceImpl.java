package com.health.service.impl;

import com.health.mapper.MessageMapper;
import com.health.mapper.ReplayMapper;
import com.health.po.Message;
import com.health.po.Replay;
import com.health.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ReplayMapper replayMapper;
    @Override
    public List<Message> findMessage() {
        List<Message> list = messageMapper.findMessage();
        if(list!=null){
            for (Message message: list) {
                Integer m_id = message.getM_id();
                List<Replay> list1 = replayMapper.selectByMid(m_id);
                message.setList(list1);
            }
        }
        return list;
    }

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public int insertMessageCount(Replay replay) {
        return messageMapper.insertMessageCount(replay);
    }
}
