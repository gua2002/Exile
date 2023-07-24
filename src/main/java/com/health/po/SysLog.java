package com.health.po;

import java.util.Date;
/**
 * @Author wuyang
 * @Description 日志实体类
 * @Param
 * @return
 **/
public class SysLog {
    private Integer id;

    private Integer userId;

    private String userAction;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction == null ? null : userAction.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}