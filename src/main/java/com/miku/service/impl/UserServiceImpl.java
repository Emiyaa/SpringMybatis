package com.miku.service.impl;

import com.miku.mapper.UserMapper;
import com.miku.po.User;
import com.miku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with com.miku.service.impl
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/6/9 0009
 * Time :       20:08
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean regist(User user) {
        boolean flag = false;
        if (userMapper.insert(user) > 0){
            flag = true;
        }
        return flag;
    }
}
