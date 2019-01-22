package com.synapse.reading.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录及其下面的item（目录或具体的信息（书籍，音频，视频等））的信息
 */
public class CatItem {

    private String name;  // 目录名称
    private List<CatItem> subCatList = new ArrayList<>();// 子目录列表
    private String itemName;  // 元素名称，与subCatList互斥，如果subCatList不为空，则此处有值，表示叶子节点
    private String itemId;    // 元素主键
    private String publishStatus; // 元素的发布状态，例如0 未发布，1 首页可见，2目录可见，3首页和目录都可见

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public void addSubCat(CatItem catItem) {
        subCatList.add(catItem);
    }
}
