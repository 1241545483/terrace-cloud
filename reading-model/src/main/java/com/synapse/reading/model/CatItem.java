package com.synapse.reading.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录及其下面的item（目录或具体的信息（书籍，音频，视频等））的信息
 */
public class CatItem {

    private String name;  // 目录名称
    private List<CatItem> subCatList = new ArrayList<>();// 子目录列表

    private List<Item> subItemList = new ArrayList<>();// 子目录列表

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CatItem> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<CatItem> subCatList) {
        this.subCatList = subCatList;
    }

    public void addSubCat(CatItem catItem) {
        subCatList.add(catItem);
    }

    public List<Item> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<Item> subItemList) {
        this.subItemList = subItemList;
    }

    public void addSItemCat(Item item) {
        subItemList.add(item);
    }

}
