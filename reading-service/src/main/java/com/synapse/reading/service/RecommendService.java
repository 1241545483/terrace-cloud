package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.*;
import com.synapse.reading.respository.RecommendRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 推荐 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@Service
@Transactional
public class RecommendService extends RecommendBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private RecommendRespository recommendRespository;

    public Recommend find(String recId) {
        return recommendRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Recommend param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        return recommendRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Recommend param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        recommendRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return recommendRespository.deleteByPrimaryKey(recId);
    }

    public List<Recommend> list(Recommend recommendParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(recommendParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return recommendRespository.list(params);
    }

    public List<Book> selectByRecommendType(String recommendType,String menu) {
        return recommendRespository.selectByRecommendType(recommendType,menu);
    }

    public Integer count(Recommend recommendParam) {
        Map<String, Object> params = prepareParams(recommendParam);
        return recommendRespository.count(params);
    }

    public List<CatItem> selectByRecommend(String recommendType,String menu) {

        List<Directories> directoriesList = recommendRespository.selectByRecommend(recommendType,menu);

        List<CatItem> catList = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        CatItem item1 = null;
        CatItem item2 = null;
        CatItem item3 = null;
        // 提供给二级目录的判断，如果一级目录重建了，则3二级目录必然要重建。处理可能一级目录不同，但是二级目录相同的情况
        boolean resetFlag = false;
        boolean resetFlag1 = false;

        if (directoriesList != null && !directoriesList.isEmpty()) {
            for (Directories dir : directoriesList) {
                if (item1 == null || !item1.getName().equals(dir.getOneLevelName())) {
                    resetFlag = true;
                    item1 = new CatItem();
                    item1.setName(dir.getOneLevelName());
                    catList.add(item1);
                }
                if (item2 == null || !item2.getName().equals(dir.getTwoLevelName()) || resetFlag) {
//                    resetFlag = false;
                    item2 = new CatItem();
                    item2.setName(dir.getTwoLevelName());
                    item1.addSubCat(item2);
                }
                if (item3 == null || !item3.getName().equals(dir.getTwoLevelName()) || resetFlag) {
                    resetFlag = false;
                    item3 = new CatItem();
                    item3.setName(dir.getThreeLevelName());
                    item2.addSubCat(item3);
                }
                Item item4 = new Item();
                item4.setItemId(dir.getItemId());
                item4.setItemName(dir.getItemName());
                item4.setPublishStatus(dir.getPublishStatus());
                item3.addSItemCat(item4);
            }
        }

        return catList;

    }

}