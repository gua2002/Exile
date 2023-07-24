package com.health.service.impl;

import com.health.mapper.WarningMapper;
import com.health.service.WarningService;
import com.health.vo.WarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName WarningServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class WarningServiceImpl implements WarningService {
    @Autowired
    private WarningMapper warningMapper;


    @Override
    public List<Integer> getSumQgradeByCid(Integer s_id, Integer e_id) {
        return warningMapper.getSumQgradeByCid(s_id,e_id);
    }

    @Override
    public WarningVo getWarningByid(Integer s_id, Integer e_id, Integer q_grade, Integer c_id) {
        return warningMapper.getWarningByid(s_id,e_id,q_grade,c_id);
    }


}
