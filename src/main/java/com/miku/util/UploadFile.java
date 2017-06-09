package com.miku.util;

import com.miku.vo.ItemsCustom;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created with com.miku.util
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/6/9 0009
 * Time :       18:25
 */
@Component
public class UploadFile {
    public int uploadPicture(HttpServletRequest request ,MultipartFile items_pic , ItemsCustom itemsCustom){
        int flag = 0;
        if (items_pic != null){
            //文件原始名称
            String fileName = items_pic.getOriginalFilename();
            if (fileName != null && fileName != "" && fileName.length() > 0){
                String path = request.getSession().getServletContext().getRealPath("/");
                //新建当前天目录
                Calendar date=Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datePath = sdf.format(date.getTime());
                File path1 = new File(path + "/pic");
                File path2 = new File(path + "/pic/" + datePath);
                if (!path2.exists()){
                    if(!path1.exists()){
                        path1.mkdir();
                    }
                    path2.mkdir();
                }
                //新文件名
                String newFileName = UUID.randomUUID() +
                        fileName.substring(fileName.lastIndexOf("."));
                //新文件
                File newFlie = new File(path + "/pic/" + datePath + "/" + newFileName);
                //将内存中的文件写入磁盘
                try {
                    items_pic.transferTo(newFlie);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //如果上传成功，将图片路径存入itemsCustom
                newFileName = "/pic/" + datePath + "/" + newFileName;
                itemsCustom.setPic(newFileName);
                flag = 1;
            }
        }
        return flag;
    }
}
