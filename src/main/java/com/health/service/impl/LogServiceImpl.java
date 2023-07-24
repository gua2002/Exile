package com.health.service.impl;

import com.health.mapper.SysLogMapper;
import com.health.po.Admin;
import com.health.po.Student;
import com.health.po.SysLog;
import com.health.po.Teacher;
import com.health.service.LogService;
import com.health.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class LogServiceImpl implements LogService {
    @Autowired(required = false)
    private SysLogMapper logMapper;
    @Override
    public void addLogInfo(SysLog sysLog) {
        logMapper.insert(sysLog);
    }
}
