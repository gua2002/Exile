package com.health.service.impl;

import com.health.mapper.StudentMapper;
import com.health.po.Student;
import com.health.service.StudentService;
import com.health.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class StudentServiceImpl implements StudentService {
   @Autowired
   private StudentMapper studentMapper;
    @Override
    public int studentPWD(Student student) {
        return studentMapper.studentPWD(student);
    }

    @Override
    public List<StudentVo> findStudents() {
        return studentMapper.findStudents();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    @Override
    public List<Student> findstudentbyid(Integer s_id) {
        return studentMapper.findstudentbyid(s_id);
    }

    @Override
    public int updatastudent(Student student) {
        return studentMapper.updatastudent(student);
    }

    @Override
    public int deleteStudentById(Integer s_id) {
        return studentMapper.deleteStudentById(s_id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Student findstudentbysid(Integer s_id) {
        return studentMapper.findstudentbysid(s_id);
    }
}
