package com.health.service;

import com.health.po.Student;
import com.health.vo.StudentVo;

import java.util.List;


/**
 * @author wuyang
 * @ClassName StudentService
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentService {

    int studentPWD(Student student);

    List<StudentVo> findStudents();

    List<Student> findAllStudents();

    List<Student> findstudentbyid(Integer s_id);

    int updatastudent(Student student);

    int deleteStudentById(Integer s_id);

    int addStudent(Student student);

    Student findstudentbysid(Integer s_id);
}
