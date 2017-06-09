package com.miku.controller;

import com.miku.exception.CustomException;
import com.miku.service.ItemsService;
import com.miku.util.UploadFile;
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
import java.util.List;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/9 0009
 * Time :       23:03
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UploadFile uploadFile;

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
        mv.setViewName("item/itemsList");
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
        return "item/editItem";
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
            return "item/editItem";
        }

        int flag = uploadFile.uploadPicture(request , items_pic , itemsCustom);
        if (flag > 0){
            itemsService.updateItem(id, itemsCustom);
            //重定向到商品列表页面  转发forward
            return "redirect:editItem?id=" + id;
        }else {
            String errors = "修改失败！";
            model.addAttribute("errors" , errors);
            return "item/editItem";
        }

    }

    // 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
    @RequestMapping("/editAllItems")
    public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception {

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        modelAndView.setViewName("item/editItemsQuery");

        return modelAndView;

    }

    // 批量修改商品提交
    // 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
    @RequestMapping("/editAllItemsSubmit")
    public String editAllItemsSubmit(ItemsQueryVo itemsQueryVo , Model model) throws Exception {

        if (itemsService.updateItems(itemsQueryVo) == itemsQueryVo.getItemsList().size()){
            //重定向到商品列表页面  转发forward
            return "redirect:queryItems";
        }else {
            //重定向到商品列表页面  转发forward
            String errors = "删除失败！";
            model.addAttribute("errors" , errors);
            return "item/queryItems";
        }
    }

    //商品删除
    @RequestMapping("/deleteItem")
    public String deleteItem(Model model , Integer id)
        throws Exception{

        if (itemsService.deleteItem(id) > 0){
            //重定向到商品列表页面  转发forward
            return "redirect:queryItems";
        }else {
            //重定向到商品列表页面  转发forward
            String errors = "删除失败！";
            model.addAttribute("errors" , errors);
            return "item/queryItems";
        }

    }

    //批量商品删除
    @RequestMapping("/deleteItems")
    public String deleteItems(Model model , Integer[] items_id)
        throws Exception{

        if (itemsService.deleteItems(items_id) == items_id.length){
            //重定向到商品列表页面  转发forward
            return "redirect:queryItems";
        }else {
            //重定向到商品列表页面  转发forward
            String errors = "删除失败！";
            model.addAttribute("errors" , errors);
            return "item/queryItems";
        }

    }

}
