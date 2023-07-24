package com.health.service.impl;

import com.health.mapper.TeacherMapper;
import com.health.po.Teacher;
import com.health.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findTeacherList() {
        return teacherMapper.findTeacherList();
    }

    @Override
    public int updataTeacherByid(Teacher teacher) {
        return teacherMapper.updataTeacherByid(teacher);
    }

    @Override
    public int deleteTeacherById(Integer t_id) {
        return teacherMapper.deleteTeacherById(t_id);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }
}
