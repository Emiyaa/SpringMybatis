package com.miku.controller;

import com.miku.po.User;
import com.miku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session ,
                        String username , String  password) {
        //调用service方法进行登录验证

        session.setAttribute("username" , username);
        //重定向到商品查询页面
        return "redirect:items/queryItems";
    }

    //登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面
        return "redirect:items/queryItems";
    }

    //跳转到注册
    @RequestMapping("/toRegist")
    public String toRegist() {
        //跳转到注册页面
        return "regist";
    }

    //跳转到注册
    @RequestMapping("/registTo")
    public ModelAndView registTo(User user,
                                 ModelAndView mv) throws Exception {

        System.out.println(user);
        //调用service方法进行注册
        if (userService.regist(user)) {
            mv.addObject("reg_message", "注册成功！");
            //重定向到登录页面
            mv.setViewName("login");
            return mv;
        } else {
            mv.addObject("reg_message", "注册失败！");
            //重定向到注册页面
            mv.setViewName("toRegist");
            return mv;
        }
    }

}
