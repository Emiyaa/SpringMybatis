package com.miku.dao;

import com.miku.po.Publicurl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with com.miku.dao
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/6/9 0009
 * Time :       19:31
 */
@Repository
public interface PublicUrlCustom {

    //查询公开地址
    public List<Publicurl> selectByUrl(String url);
}
