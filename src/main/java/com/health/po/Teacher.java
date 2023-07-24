package com.health.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author wuyang
 * @ClassName Teacher  教师实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer t_id;              //教师工号
    private String t_name;             //教师姓名
    private String t_password;         //教师登录密码
    private String t_college;          //教师所属学院 默认渭南师范学院
    private String t_sex;              //教师性别
    private String t_type;             //教师职称
    private String t_image;
    private Integer role;              //教师权限  默认1

}
