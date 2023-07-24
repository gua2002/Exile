package com.health.service;

import com.health.po.Answers;
import com.health.vo.AnswersVo;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnswersService
 * @Description TODO
 * @Version 1.0
 **/
public interface AnswersService {

    List<AnswersVo> findAnswers(Integer e_id);

    int insertAnswers(Answers answers);
}
