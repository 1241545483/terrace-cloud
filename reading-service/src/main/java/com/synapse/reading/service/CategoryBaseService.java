package com.synapse.reading.service;

import com.synapse.reading.model.Category;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 推荐中高考书籍目录（三级） 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
public class CategoryBaseService {

	protected Map<String,Object> prepareParams(Category categoryParam) {
        Map<String,Object> params = new HashMap<>();
        if (categoryParam.getRecId() != null && !categoryParam.getRecId().trim().equals("")) {
            params.put("recId", categoryParam.getRecId());
        }
        if (categoryParam.getName() != null && !categoryParam.getName().trim().equals("")) {
            params.put("name", categoryParam.getName());
        }
        if (categoryParam.getPid() != null && !categoryParam.getPid().trim().equals("")) {
            params.put("pid", categoryParam.getPid());
        }
        if (categoryParam.getPpid() != null && !categoryParam.getPpid().trim().equals("")) {
            params.put("ppid", categoryParam.getPpid());
        }
        if (categoryParam.getItemId() != null && !categoryParam.getItemId().trim().equals("")) {
            params.put("itemId", categoryParam.getItemId());
        }
        if (categoryParam.getItemType() != null && !categoryParam.getItemType().trim().equals("")) {
            params.put("itemType", categoryParam.getItemType());
        }
        if (categoryParam.getLevel() != null && !categoryParam.getLevel().trim().equals("")) {
            params.put("level", categoryParam.getLevel());
        }
        if (categoryParam.getCreateId() != null && !categoryParam.getCreateId().trim().equals("")) {
            params.put("createId", categoryParam.getCreateId());
        }
        if (categoryParam.getCreateTime() != null && !categoryParam.getCreateTime().trim().equals("")) {
            params.put("createTime", categoryParam.getCreateTime());
        }
        if (categoryParam.getUpdateId() != null && !categoryParam.getUpdateId().trim().equals("")) {
            params.put("updateId", categoryParam.getUpdateId());
        }
        if (categoryParam.getUpdateTime() != null && !categoryParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", categoryParam.getUpdateTime());
        }
        return params;
    }

}