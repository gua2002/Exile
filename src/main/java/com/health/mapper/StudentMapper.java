package com.health.mapper;

import com.health.po.Student;
import com.health.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wuyang
 * @ClassName StudentMapper
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentMapper {

    Student studentLogin(@Param("s_id") Integer s_id, @Param("s_password") String s_password);

    int studentPWD(Student student);

    List<StudentVo> findStudents();

    List<Student> findAllStudents();

    List<Student> findstudentbyid(@Param("s_id") Integer s_id);

    int updatastudent(Student student);

    int deleteStudentById(@Param("s_id") Integer s_id);

    int addStudent(Student student);

    Student findstudentbysid(Integer s_id);
}
