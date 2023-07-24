package com.health.mapper;

import com.health.po.Replay;
import java.util.List;

/**
 * @author wuyang
 * @ClassName ReplayMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface ReplayMapper {


    List<Replay> selectByMid(Integer m_id);
}
