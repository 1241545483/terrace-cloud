package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Book;
import com.synapse.reading.respository.BookRespository;
import com.synapse.reading.dto.param.BookParam;
import com.synapse.reading.dto.result.BookResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.BookConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@Service
@Transactional
public class BookService extends BookBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private BookRespository bookRespository;

    public Book find(String recId){
	    return bookRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Book param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return bookRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Book param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(BookConstants.STATUS.OK.num());
        bookRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Book model = new Book();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(BookConstants.STATUS.DELETED.num());
        return bookRespository.updateByPrimaryKeySelective(model);
    }

	public List<Book> list(Book bookParam, PageInfo pageInfo) {
		bookParam.setStatus(BookConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(bookParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return bookRespository.list(params);
	}

    public List<Book> selectByRecommendType(String recommendtType) {
        return bookRespository.selectByRecommendType(recommendtType);
    }

	public Integer count(Book bookParam) {
		bookParam.setStatus(BookConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(bookParam);
        return bookRespository.count(params);
    }

}