package com.health.service.impl;

import com.health.mapper.ClassificationMapper;
import com.health.po.Classification;
import com.health.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ClassificationServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationMapper classificationMapper;

    @Override
    public List<Classification> findHealthWaringScore() {
        return classificationMapper.findHealthWaringScore();
    }
}
