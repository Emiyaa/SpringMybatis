package com.miku.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with com.miku.exception
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/11 0011
 * Time :       16:20
 */
//全局异常处理器
public class CustomExceptionResolver
        implements HandlerExceptionResolver{

    //handler是处理器适配器要执行的handler对象(只有method)
    //ex 系统抛出的异常
    @Override
    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex) {
        //解析异常的类型
        //如果是自定义的异常，直接取出异常信息，在错误页显示
//        String message = null;
//        if (ex instanceof CustomException){
//            message = ((CustomException)ex).getMessage();
//        }else {
//             message = "系统发生未知错误,请联系管理员！";
//        }
        CustomException customException = null;
        if (ex instanceof CustomException){
            customException = (CustomException)ex;
        }else {
            //如果不是自定义的异常，则构造一个自定义异常
            customException = new CustomException
                    ("系统发生未知错误,请联系管理员！");
        }
        //获取错误信息
        String message = customException.getMessage();
        ModelAndView mv = new ModelAndView();
        //将错误信息传到错误页面，并跳转显示
        mv.addObject("message" , message);
        mv.setViewName("error");
        return mv;
    }
}
