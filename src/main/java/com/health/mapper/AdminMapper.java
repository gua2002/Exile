package com.health.mapper;

import com.health.po.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author wuyang
 * @ClassName AdminMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface AdminMapper {

    Admin adminLogin(@Param("a_id") Integer a_id, @Param("a_password") String a_password);
}
