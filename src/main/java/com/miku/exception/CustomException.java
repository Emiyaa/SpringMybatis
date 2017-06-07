package com.miku.exception;

/**
 * Created with com.miku.exception
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/11 0011
 * Time :       16:16
 */
//自定义异常处理类
public class CustomException extends Exception{
    //定义存储异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
