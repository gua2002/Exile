package com.health.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author wuyang
 * @ClassName student实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer s_id;             //学号
    private String s_name;            //姓名
    private String s_password;        //密码
    private String s_college;         //二级学院
    private String s_major;           //专业
    private String s_class;           //班级
    private String s_phone;           //联系方式
    private String s_image;           //头像
    private String s_sex;             //学生性别
    private Integer role;             //学生权限   2
}
