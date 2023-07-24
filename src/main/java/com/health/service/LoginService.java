package com.health.service;

import com.health.po.Admin;
import com.health.po.Student;
import com.health.po.Teacher;

/**
 * @author wuyang
 * @ClassName LoginService
 * @Description TODO
 * @Version 1.0
 **/
public interface LoginService {

    Admin adminLogin(Integer uid, String password);

    Teacher teacherLogin(Integer uid, String password);

    Student studentLogin(Integer uid, String password);
}
