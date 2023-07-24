package com.health.service;

import com.health.vo.WarningVo;

import java.util.List;

/**
 * @author wuyang
 * @ClassName WarningService
 * @Description TODO
 * @Version 1.0
 **/
public interface WarningService {



    List<Integer> getSumQgradeByCid(Integer s_id, Integer e_id);


    WarningVo getWarningByid(Integer s_id, Integer e_id, Integer q_grade, Integer c_id);
}
