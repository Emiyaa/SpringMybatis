package com.miku.controller;

import com.miku.exception.CustomException;
import com.miku.service.ItemsService;
import com.miku.vo.ItemsCustom;
import com.miku.vo.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/9 0009
 * Time :       23:03
 */
@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo){
        //返回ModelAndView
        ModelAndView mv = new ModelAndView();
        //调用service查询
        List<ItemsCustom> itemsList =
                itemsService.findItemsList(itemsQueryVo);

        //相当于Request的setAttribute，
        // 在jsp页面中通过itemsList取数据
        mv.addObject("itemsList", itemsList);
        //指定返回视图
        mv.setViewName("itemsList");
        return mv;
    }

    //商品修改显示
    @RequestMapping("/editItem")
    public String editItem(Model model , Integer id)
    throws Exception{
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        if (itemsCustom == null){
            throw new CustomException("没有该商品！");
        }
        model.addAttribute("items", itemsCustom);
        return "editItem";
    }

    //商品修改提交
    @RequestMapping("/editItems")
    //在要校验的pojo前添加@Validated
    //在要校验的pojo后添加BindingResult
    //两个参数成对出现，一前一后
    //@ModelAttribute指定pojo回显到页面的request中的key
    public String editItems(Model model , Integer id ,
            HttpServletRequest request ,
            @ModelAttribute("items")
            @Validated ItemsCustom itemsCustom ,
            BindingResult bindingResult ,
            MultipartFile items_pic)
        throws Exception{

        //获取校验错误信息
        if (bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> errors = bindingResult.getAllErrors();
            model.addAttribute("errors" , errors);
            return "editItem";
        }

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
                items_pic.transferTo(newFlie);
                //如果上传成功，将图片路径存入itemsCustom
                newFileName = "/pic/" + datePath + "/" + newFileName;
                itemsCustom.setPic(newFileName);
            }
        }
        itemsService.updateItems(id , itemsCustom);
        //重定向到商品列表页面  转发forward
        return "redirect:editItem?id=" + id;
    }

}
