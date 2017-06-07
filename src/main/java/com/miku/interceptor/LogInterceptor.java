package com.miku.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with com.miku.interceptor
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/12 0012
 * Time :       17:40
 */
//系统日志
public class LogInterceptor
        implements HandlerInterceptor{

    //进入Handler方法之前执行
    //用于身份验证等
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //因为作为系统日志，必须放行
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //此处记录系统错误信息

    }
}
