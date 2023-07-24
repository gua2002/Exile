package com.health.service.impl;

import com.health.mapper.AdminMapper;
import com.health.mapper.StudentMapper;
import com.health.mapper.TeacherMapper;
import com.health.po.Admin;
import com.health.po.Student;
import com.health.po.Teacher;
import com.health.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Admin adminLogin(Integer a_id, String a_password) {
        return adminMapper.adminLogin(a_id,a_password);
    }

    @Override
    public Teacher teacherLogin(Integer t_id, String t_password) {
        return teacherMapper.teacherLogin(t_id,t_password);
    }

    @Override
    public Student studentLogin(Integer s_id, String s_password) {
        return studentMapper.studentLogin(s_id,s_password);
    }
}
