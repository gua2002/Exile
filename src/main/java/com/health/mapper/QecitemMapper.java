package com.health.mapper;
import com.health.vo.QecitemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wuyang
 * @ClassName QecitemMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface QecitemMapper {
    List<Integer> getQuestion(Integer c_id);

    int insertQec(QecitemVo qecitemVo);

    void deleteQecitem(@Param("e_id") Integer e_id,@Param("s_id") Integer s_id);
}
