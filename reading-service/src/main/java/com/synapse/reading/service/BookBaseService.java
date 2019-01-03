package com.synapse.reading.service;

import com.synapse.reading.model.Book;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-03
 */
public class BookBaseService {

	protected Map<String,Object> prepareParams(Book bookParam) {
        Map<String,Object> params = new HashMap<>();
        if (bookParam.getRecId() != null && !bookParam.getRecId().trim().equals("")) {
            params.put("recId", bookParam.getRecId());
        }
        if (bookParam.getName() != null && !bookParam.getName().trim().equals("")) {
            params.put("name", bookParam.getName());
        }
        if (bookParam.getAuthor() != null && !bookParam.getAuthor().trim().equals("")) {
            params.put("author", bookParam.getAuthor());
        }
        if (bookParam.getIntro() != null && !bookParam.getIntro().trim().equals("")) {
            params.put("intro", bookParam.getIntro());
        }
        if (bookParam.getSlogan() != null && !bookParam.getSlogan().trim().equals("")) {
            params.put("slogan", bookParam.getSlogan());
        }
        if (bookParam.getType() != null && !bookParam.getType().trim().equals("")) {
            params.put("type", bookParam.getType());
        }
        if (bookParam.getCover() != null && !bookParam.getCover().trim().equals("")) {
            params.put("cover", bookParam.getCover());
        }
        if (bookParam.getBanner() != null && !bookParam.getBanner().trim().equals("")) {
            params.put("banner", bookParam.getBanner());
        }
        if (bookParam.getQrCode() != null && !bookParam.getQrCode().trim().equals("")) {
            params.put("qrCode", bookParam.getQrCode());
        }
        if (bookParam.getPublishStatus() != null && !bookParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", bookParam.getPublishStatus());
        }
        if (bookParam.getStatus() != null && !bookParam.getStatus().trim().equals("")) {
            params.put("status", bookParam.getStatus());
        }
        if (bookParam.getOrderNum() != null) {
            params.put("orderNum", bookParam.getOrderNum());
        }
        if (bookParam.getVisitNum() != null) {
            params.put("visitNum", bookParam.getVisitNum());
        }
        if (bookParam.getCreateId() != null && !bookParam.getCreateId().trim().equals("")) {
            params.put("createId", bookParam.getCreateId());
        }
        if (bookParam.getCreateTime() != null && !bookParam.getCreateTime().trim().equals("")) {
            params.put("createTime", bookParam.getCreateTime());
        }
        if (bookParam.getUpdateId() != null && !bookParam.getUpdateId().trim().equals("")) {
            params.put("updateId", bookParam.getUpdateId());
        }
        if (bookParam.getUpdateTime() != null && !bookParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", bookParam.getUpdateTime());
        }
        return params;
    }

}