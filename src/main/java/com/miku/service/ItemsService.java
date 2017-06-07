package com.miku.service;

import com.miku.vo.ItemsCustom;
import com.miku.vo.ItemsQueryVo;

import java.util.List;

/**
 * Created with com.miku.service
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/9 0009
 * Time :       22:47
 */
public interface ItemsService {
    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVO);

    //根据id查询商品信息
    public ItemsCustom findItemsById(Integer id);

    //商品信息修改
    public void updateItems(Integer id , ItemsCustom itemsCustom);
}
