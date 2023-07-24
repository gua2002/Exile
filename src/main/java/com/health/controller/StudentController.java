package com.health.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Student;
import com.health.service.StudentService;
import com.health.util.QiniuUpload;
import com.health.util.ResultHandler;
import com.health.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wuyang
 * @ClassName 学生信息控制
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PutMapping("/studentPWD")
    @ResponseBody
    public ActionResult studentPWD(@RequestBody Student student){
       int count= studentService.studentPWD(student);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "更新成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(400, "更新失败!!!", null);
        }
    }

    @GetMapping("/students/{current}/{size}")
    @ResponseBody
    public ActionResult findStudents(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageHelper.startPage(current, size);
        List<StudentVo> list = studentService.findStudents();
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @GetMapping("/findstudents/{current}/{size}")
    @ResponseBody
    public ActionResult findAllStudents(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageHelper.startPage(current, size);
        List<Student> list = studentService.findAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @GetMapping("/findstudentbyid/{s_id}")
    @ResponseBody
    public ActionResult findAllStudentBySid(@PathVariable("s_id") Integer s_id) {
        List<Student> list = studentService.findstudentbyid(s_id);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", list);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @GetMapping("/findstudentid/{s_id}")
    @ResponseBody
    public ActionResult findAllStudentByid(@PathVariable("s_id") Integer s_id) {
        Student student= studentService.findstudentbysid(s_id);
        if (student != null) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", student);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }


    @PutMapping("/updatastudent")
    @ResponseBody
    public ActionResult updatastudentBySid(@RequestBody Student student) {
        int count = studentService.updatastudent(student);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @DeleteMapping("/deletestudent/{s_id}")
    @ResponseBody
    public ActionResult deleteStudentById(@PathVariable("s_id") Integer s_id){
        int count=studentService.deleteStudentById(s_id);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "删除成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "删除失败!!!", null);
        }
    }

    @PostMapping("/addstudent")
    @ResponseBody
    public ActionResult addStudent(@RequestBody Student student){
       int count= studentService.addStudent(student);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "添加成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "添加失败!!!", null);
        }
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ActionResult uploadFile(@RequestParam("file") MultipartFile file){
        ActionResult result = new ActionResult();
        result.setCode(200);
//        上传文件
        String url = QiniuUpload.uploadFile(file);
        result.setData(url);
        return new ActionResult(200,"上传成功",url);
    }
}
