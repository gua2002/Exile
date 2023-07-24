package com.health.controller;

import com.health.aop.MyLog;
import com.health.dto.ActionResult;
import com.health.po.Admin;
import com.health.po.Student;
import com.health.po.Teacher;
import com.health.service.LoginService;
import com.health.util.JwtUtils;
import com.health.vo.LoginVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyang
 * @ClassName LoginController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户学/工号", required = true),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true)
    })
    @MyLog(name = "用户登录")
    @PostMapping("/login")
    @ResponseBody
    public ActionResult login(@RequestBody LoginVo login) {
        Integer uid = login.getUid();
        String password = login.getPassword();
        Map data = new HashMap();
        String token;
        String msg;

        Admin admin = loginService.adminLogin(uid, password);
        if(admin!=null && admin.getRole()==0){
            msg = "欢迎您!尊贵的管理员";
            token = JwtUtils.sign(Integer.toString(admin.getRole()));
            data.put("token",token);
            data.put("role",admin.getRole());
            data.put("userid",admin.getA_id());
            data.put("username",admin.getA_name());
            data.put("userimage",admin.getA_image());
            data.put("msg",msg);
            return new ActionResult(200,msg,data);
        }

        Teacher teacher = loginService.teacherLogin(uid, password);
        if(teacher!=null && teacher.getRole()==1){
            msg = "欢迎您!"+teacher.getT_name()+"老师";
            token = JwtUtils.sign(Integer.toString(teacher.getRole()));
            data.put("token",token);
            data.put("role",teacher.getRole());
            data.put("userid",teacher.getT_id());
            data.put("username",teacher.getT_name());
            data.put("userimage",teacher.getT_image());
            data.put("msg",msg);
            return new ActionResult(200,msg,data);
        }

        Student student = loginService.studentLogin(uid, password);
        if(student!=null && student.getRole()==2){
            msg = "欢迎您!"+student.getS_name()+"同学";
            token = JwtUtils.sign(Integer.toString(student.getRole()));
            data.put("token",token);
            data.put("role",student.getRole());
            data.put("userid",student.getS_id());
            data.put("username",student.getS_name());
            data.put("userimage",student.getS_image());
            data.put("msg",msg);
            return new ActionResult(200,msg,data);
        }

        msg = "登陆失败!查无此人!";
        return new ActionResult(500,msg,null);
    }
}
