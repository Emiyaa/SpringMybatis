package com.miku.vo;

import com.miku.po.Items;

/**
 * Created with com.miku.vo
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/9 0009
 * Time :       22:24
 */
public class ItemsQueryVo {
    //商品信息
    private Items items;
    //为了系统的可扩展性，对原始生成的po进行扩展
    private ItemsCustom itemsCustom;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
