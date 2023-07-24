package com.health.service;
import com.health.vo.QecitemVo;

import java.util.List;

/**
 * @author wuyang
 * @ClassName QecitemService
 * @Description TODO
 * @Version 1.0
 **/
public interface QecitemService {
    List<Integer> getQuestion(Integer c_id);

    int inertQec(QecitemVo qecitemVo);

    void deleteQecitem(Integer e_id, Integer s_id);
}
