package com.health.service;

import com.health.po.Classification;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ClassificationService
 * @Description TODO
 * @Version 1.0
 **/
public interface ClassificationService {

    List<Classification> findHealthWaringScore();
}
