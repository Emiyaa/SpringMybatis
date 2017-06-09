package com.miku.dao;

import com.miku.po.User;
import org.springframework.stereotype.Repository;

/**
 * Created with com.miku.dao
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/6/9 0009
 * Time :       17:40
 */
@Repository
public interface UserMapperCustom {

    //登录查询
    public User selectByUsername(String username);
}
