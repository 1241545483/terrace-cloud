package com.synapse.reading.dto.param;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MiniQrcodeParam对象", description = "小程序二维码参数对象")
public class MiniQrcodeParam {
    private String  page;
    private String scene;
    private String width;
    private Boolean auto_color = true;
    private Boolean is_hyaline;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Boolean getAuto_color() {
        return auto_color;
    }

    public void setAuto_color(Boolean auto_color) {
        this.auto_color = auto_color;
    }

    public Boolean getIs_hyaline() {
        return is_hyaline;
    }

    public void setIs_hyaline(Boolean is_hyaline) {
        this.is_hyaline = is_hyaline;
    }
}
