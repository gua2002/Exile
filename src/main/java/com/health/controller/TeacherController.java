package com.health.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Student;
import com.health.po.Teacher;
import com.health.service.TeacherService;
import com.health.util.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName 教师控制
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findteacherlist/{current}/{size}")
    @ResponseBody
    public ActionResult findTeacherList(@PathVariable("current") Integer current, @PathVariable("size") Integer size){
        PageHelper.startPage(current, size);
        List<Teacher> list = teacherService.findTeacherList();
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @PutMapping("/updatateacher")
    @ResponseBody
    public ActionResult updataTeacherByid(@RequestBody Teacher teacher) {
        int count = teacherService.updataTeacherByid(teacher);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "更新成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "更新失败!!!", null);
        }
    }

    @DeleteMapping("/delteacher/{t_id}")
    @ResponseBody
    public ActionResult deleteTeacherById(@PathVariable("t_id") Integer t_id){
        int count=teacherService.deleteTeacherById(t_id);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "删除成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "删除失败!!!", null);
        }
    }

    @PostMapping("/addteacher")
    @ResponseBody
    public ActionResult addTeacher(@RequestBody Teacher teacher){
        int count= teacherService.addTeacher(teacher);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "添加成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "添加失败!!!", null);
        }
    }
}
