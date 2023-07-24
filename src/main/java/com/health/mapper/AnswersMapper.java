package com.health.mapper;

import com.health.po.Answers;
import com.health.vo.AnswersVo;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnswersMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface AnswersMapper {
    List<AnswersVo> findAnswers(Integer e_id);

    int insertAnswers(Answers answers);
}
