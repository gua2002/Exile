package com.health.aop;

import com.health.po.SysLog;
import com.health.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component  //由spring管理
@Aspect   //标为切面
public class SysLogAop {
//    注入日志的数据库操作对象
    @Autowired(required = false)
    private LogService logService;
//    定义一个切点
    @Pointcut("@annotation(com.health.aop.MyLog)")
    public void pointCut(){}

    @Around(value="pointCut()")  //将节点通过环绕通知的注解织在一起
    public Object around(ProceedingJoinPoint point){

        try {
//            入方法之前处理的事
//            通过切点获取方法签名对象
            MethodSignature signature =(MethodSignature) point.getSignature();
//            从方法签名对象中得到方法对象，再从方法对象得到方法含有的指定注解
            MyLog annotation = signature.getMethod().getAnnotation(MyLog.class);
            String userAction ="";
            if(annotation!=null){
//                读取注解的属性值
                 userAction = annotation.name();
            }
//            记录用户访问的日志
//            创建日志对象
            SysLog sysLog = new SysLog();
            sysLog.setUserId(1); //用户id
            sysLog.setUserAction(userAction); //用户访问动作
            sysLog.setCreateTime(new Date());  //产生的时间
            logService.addLogInfo(sysLog);//将日志对象写入表中
          return  point.proceed(); //原有的拦截逻辑
//            出方法之后处理的事
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
