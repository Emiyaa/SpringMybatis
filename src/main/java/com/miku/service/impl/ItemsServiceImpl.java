package com.miku.service.impl;

import com.miku.dao.ItemsMapperCustom;
import com.miku.mapper.ItemsMapper;
import com.miku.po.Items;
import com.miku.service.ItemsService;
import com.miku.vo.ItemsCustom;
import com.miku.vo.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with com.miku.service.impl
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/9 0009
 * Time :       22:50
 */
@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVO) {
        //通过ItemsMapperCustom查询数据库
        return itemsMapperCustom.findItemsList(itemsQueryVO);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = null;
        //将items中的属性拷贝到itemsCustom中
        if (items != null){
            itemsCustom = new ItemsCustom();
            BeanUtils.copyProperties(items , itemsCustom);
        }
        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) {
        //添加业务校验
        if (id != null){
            //更新商品信息
            //传入id
            itemsCustom.setId(id);
            //根据id更新所有信息
            itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
        }else {
            System.out.println("修改id为空！");
        }
    }


}
