package com.health.service.impl;

import com.health.mapper.EvaluatingMapper;
import com.health.po.Evaluating;
import com.health.service.EvaluatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName EvaluatingServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class EvaluatingServiceImpl implements EvaluatingService {
    @Autowired
    private EvaluatingMapper evaluatingMapper;
    @Override
    public List<Evaluating> findEvaluating() {
        return evaluatingMapper.findEvaluating();
    }

    @Override
    public Evaluating findEvaluatInfo(Integer e_id) {
        return evaluatingMapper.findEvaluatInfo(e_id);
    }

    @Override
    public int updataEvaluatingByid(Evaluating evaluating) {
        return evaluatingMapper.updataEvaluatingByid(evaluating);
    }

    @Override
    public int deleteEvaluatingById(Integer e_id) {
        return evaluatingMapper.deleteEvaluatingById(e_id);
    }

    @Override
    public int addEvaluating(Evaluating evaluating) {
        return evaluatingMapper.addEvaluating(evaluating);
    }

    @Override
    public List<Evaluating> findAllEvaluating() {
        return evaluatingMapper.findAllEvaluating();
    }

}
