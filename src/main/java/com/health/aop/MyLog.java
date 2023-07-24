package com.health.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)  //注解使用的位置
@Retention(RetentionPolicy.RUNTIME)  //注解使用的作用域（生效策略）
@Documented  //标识此注解可自动生成文档
public @interface MyLog {
//    用户区分相同请求path的描述
    public String name() default "";

}
