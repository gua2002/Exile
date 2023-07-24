package com.health.service.impl;

import com.health.mapper.EsMapper;
import com.health.po.Esitem;
import com.health.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 * @ClassName EsServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class EsServiceImpl implements EsService {
    @Autowired
    private EsMapper esMapper;
    @Override
    public int updataState(Esitem esitem) {
        return esMapper.updataState(esitem);
    }

    @Override
    public int insertEsc(Esitem esitem) {
        return esMapper.insertEsc(esitem);
    }

    @Override
    public int insertEsceid(Integer e_id) {
        return esMapper.insertEsceid(e_id);
    }

    @Override
    public int deleteEsceid(Integer e_id) {
        return esMapper.deleteEsceid(e_id);
    }


}
