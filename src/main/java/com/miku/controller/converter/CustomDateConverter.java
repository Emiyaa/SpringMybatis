package com.miku.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with com.miku.controller.converter
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/10 0010
 * Time :       22:37
 */
public class CustomDateConverter
        implements Converter<String , Date>{

    @Override
    public Date convert(String source) {
        //实现将字符串日期转换成日期类型
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //转换成功直接返回
            return sdf.parse(source);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //转换失败返回null
        return null;
    }
}
