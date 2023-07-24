package com.health.mapper;

import com.health.po.Classification;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ClassificationMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface ClassificationMapper {

    List<Classification> findHealthWaringScore();
}
