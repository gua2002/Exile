package com.health.mapper;

import com.health.po.Esitem;

/**
 * @author wuyang
 * @ClassName EsMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface EsMapper {
    int updataState(Esitem esitem);

    int insertEsc(Esitem esitem);

    int insertEsceid(Integer e_id);

    int deleteEsceid(Integer e_id);
}
