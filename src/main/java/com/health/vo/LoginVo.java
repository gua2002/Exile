package com.health.vo;

import lombok.Data;

/**
 * @author wuyang
 * @ClassName LoginVo 登录模型类
 * @Description TODO
 * @Version 1.0
 **/
@Data
public class LoginVo {
    private Integer uid;
    private String  password;
    private Integer role;
    private String image;
}
