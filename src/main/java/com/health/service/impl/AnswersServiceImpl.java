package com.health.service.impl;

import com.health.mapper.AnswersMapper;
import com.health.po.Answers;
import com.health.service.AnswersService;
import com.health.vo.AnswersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyang
 * @ClassName AnswersServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    private AnswersMapper answersMapper;

    @Override
    public List<AnswersVo> findAnswers(Integer e_id) {

        List<AnswersVo> answers = answersMapper.findAnswers(e_id);

        return answers;
    }

    @Override
    public int insertAnswers(Answers answers) {
        return answersMapper.insertAnswers(answers);
    }
}
