package com.health.service.impl;

import com.health.mapper.QecitemMapper;
import com.health.service.QecitemService;
import com.health.vo.QecitemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName QecServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class QecitemServiceImpl implements QecitemService {
    @Autowired
    private QecitemMapper qecitemMapper;
    @Override
    public List<Integer> getQuestion(Integer c_id) {
        return qecitemMapper.getQuestion(c_id);
    }

    @Override
    public int inertQec(QecitemVo qecitemVo) {
        return qecitemMapper.insertQec(qecitemVo);
    }

    @Override
    public void deleteQecitem(Integer e_id, Integer s_id) {
        qecitemMapper.deleteQecitem(e_id,s_id);
    }
}
