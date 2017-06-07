package com.miku.dao;

import com.miku.vo.ItemsCustom;
import com.miku.vo.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsMapperCustom {
    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVO);
}