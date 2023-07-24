package com.health.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author wuyang
 * @ClassName Admin 实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer a_id;                //管理员工号
    private String a_name;               //管理员姓名
    private String a_password;           //管理员密码
    private String a_image;              //管理员头像
    private Integer role;                //管理员权限   默认0
}
