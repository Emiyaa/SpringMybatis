package com.miku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/12 0012
 * Time :       17:42
 */
@Controller
public class LoginController {

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session ,
                        String username , String  password) {
        //调用service方法进行登录验证

        session.setAttribute("username" , username);
        //重定向到商品查询页面
        return "redirect:/queryItems";
    }

    //登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面
        return "redirect:/queryItems";
    }

}
