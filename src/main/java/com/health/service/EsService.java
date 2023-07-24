package com.health.service;

import com.health.po.Esitem;

/**
 * @author wuyang
 * @ClassName EsService
 * @Description TODO
 * @Version 1.0
 **/
public interface EsService {

    int updataState(Esitem esitem);

    int insertEsc(Esitem esitem);

    int insertEsceid(Integer e_id);

    int deleteEsceid(Integer e_id);
}
