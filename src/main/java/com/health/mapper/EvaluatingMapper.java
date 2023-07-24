package com.health.mapper;

import com.health.po.Evaluating;

import java.util.List;

/**
 * @author wuyang
 * @ClassName EvaluatingMapper
 * @Description TODO
 * @Version 1.0
 **/

public interface EvaluatingMapper {
    List<Evaluating> findEvaluating();

    Evaluating findEvaluatInfo(Integer e_id);

    int updataEvaluatingByid(Evaluating evaluating);

    int deleteEvaluatingById(Integer e_id);

    int addEvaluating(Evaluating evaluating);

    List<Evaluating> findAllEvaluating();
}
