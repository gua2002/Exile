package com.health.interceptor;

import com.google.gson.Gson;
import com.health.annotation.LoginToken;
import com.health.dto.ActionResult;
import com.health.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @Author wuyang
 * @Description 全局权限拦截器
 * @Param
 * @return
 **/
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
    /**
     * 事前（进入接口方法前）处理
     * @param request
     * @param response
     * @param handler  代理的方法对象
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("---------"+requestURI);
        String token = request.getHeader("token");

//        String xx = request.getParameter("xx");
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod)handler;
//             获取拦截的方法
            Method method = hm.getMethod();
            LoginToken jwtAnno = method.getAnnotation(LoginToken.class);
            if(jwtAnno!=null){  //方法前含有指定的注解，需要验证token
                boolean checkToken = JwtUtils.checkToken(token);
                log.info("==========="+token+":"+checkToken);
                if(checkToken){
                    return true;
                }else{
                    ActionResult actionResult = new ActionResult(403, "token invidite", null);
                    String json = new Gson().toJson(actionResult);
                    PrintWriter out = response.getWriter();
                    response.setHeader("contentType","application/json");
                    out.write(json);
                    return false;
                }
            }else{//无需拦截的处理方法
                return true;
            }
        }else{
            return true;
        }
    }


//事后（执行完接口逻辑，未进入视图解析器前）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
// 解析完返回视图
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
