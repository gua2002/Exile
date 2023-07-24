package com.health.service;

import com.health.po.Teacher;

import java.util.List;

/**
 * @author wuyang
 * @ClassName TeacherService
 * @Description TODO
 * @Version 1.0
 **/
public interface TeacherService {
    List<Teacher> findTeacherList();

    int updataTeacherByid(Teacher teacher);

    int deleteTeacherById(Integer t_id);

    int addTeacher(Teacher teacher);
}
