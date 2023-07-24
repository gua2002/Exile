package com.health.mapper;

import com.health.po.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wuyang
 * @ClassName TeacherMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface TeacherMapper {

    Teacher teacherLogin(@Param("t_id") Integer t_id, @Param("t_password") String t_password);

    List<Teacher> findTeacherList();

    int updataTeacherByid(Teacher teacher);

    int deleteTeacherById(Integer t_id);

    int addTeacher(Teacher teacher);
}
