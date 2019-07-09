package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.LessonConstants;
import com.synapse.reading.dto.param.ClassTaskStudyParam;
import com.synapse.reading.dto.param.SelectTaskParam;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Task;
import com.synapse.reading.model.TaskStudyMapping;
import com.synapse.reading.respository.TaskRespository;
import com.synapse.reading.dto.param.TaskParam;
import com.synapse.reading.dto.result.TaskResult;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.respository.TaskStudyMappingRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TaskConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@Service
@Transactional
public class TaskService extends TaskBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private TaskRespository taskRespository;
    @Autowired
    private TaskStudyMappingService taskStudyMappingService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private BookService bookService;
    @Autowired
    private TaskStudyMappingRespository taskStudyMappingRespository;

    private Logger logger = LoggerFactory.getLogger(TaskService.class);

    public Task find(String recId) {
        return taskRespository.selectByPrimaryKey(recId);
    }

    public TaskResult findByStudy(String recId) {
        TaskResult taskResult = taskRespository.selectTask(recId);
        List<String> lessonIds = taskStudyMappingService.getStudyIds(recId, "lesson");
        logger.warn("------------------lessonIds="+lessonIds);
        if (lessonIds != null && lessonIds.size() > 0) {
            List<Lesson> lessons = lessonService.listByLessonIds(lessonIds);
            logger.warn("------------------lessons="+lessons);
            if (lessons != null && lessons.size() > 0) {
                taskResult.setLessonList(lessons);
            }
        }
        List<String> bookIds = taskStudyMappingService.getStudyIds(recId, "book");
        logger.warn("------------------bookIds="+bookIds);
        if (bookIds != null && bookIds.size() > 0) {
            List<Book> books = bookService.listByBookIds(bookIds);
            logger.warn("------------------books="+books);
            if (books != null && books.size() > 0) {
                taskResult.setBookList(books);
            }
        }


        return taskResult;
    }

    public Integer getNum(String userId) {
        return taskStudyMappingRespository.getNum(userId);
    }

    public Integer update(Task param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return taskRespository.updateByPrimaryKeySelective(param);
    }

    public Integer updateByStudy(TaskParam param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.getModel().setUpdateTime(now);
        taskRespository.updateByPrimaryKeySelective(param.getModel());
        taskStudyMappingService.deleteByStudyId(param.getRecId());
        if (param.getClassTaskStudyParams() != null && param.getClassTaskStudyParams().size() > 0) {
            for (ClassTaskStudyParam classTaskStudyParam : param.getClassTaskStudyParams()) {
                TaskStudyMapping taskStudyMapping = new TaskStudyMapping();
                taskStudyMapping.setTaskId(param.getRecId());
                taskStudyMapping.setStudyId(classTaskStudyParam.getStudyId());
                taskStudyMapping.setStudyType(classTaskStudyParam.getStudyType());
                taskStudyMappingService.create(taskStudyMapping);
            }
        }
        return 1;
    }


    public String createByStudy(TaskParam param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.getModel().setRecId(idService.gen("ID"));
        param.getModel().setCreateTime(now);
        param.getModel().setUpdateTime(now);
        param.getModel().setStatus(TaskConstants.STATUS.OK.num());
        taskRespository.insert(param.getModel());
        if (param.getClassTaskStudyParams() != null && param.getClassTaskStudyParams().size() > 0) {
            for (ClassTaskStudyParam classTaskStudyParam : param.getClassTaskStudyParams()) {
                TaskStudyMapping taskStudyMapping = new TaskStudyMapping();
                taskStudyMapping.setTaskId(param.getRecId());
                taskStudyMapping.setStudyId(classTaskStudyParam.getStudyId());
                taskStudyMapping.setStudyType(classTaskStudyParam.getStudyType());
                taskStudyMappingService.create(taskStudyMapping);
            }
        }
        return param.getRecId();
    }

    public String create(Task param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(TaskConstants.STATUS.OK.num());
        taskRespository.insert(param);
        return param.getRecId();
    }

    public Integer deleteByStudy(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Task model = new Task();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TaskConstants.STATUS.DELETED.num());
        taskStudyMappingService.deleteByStudyId(recId);
        return taskRespository.updateByPrimaryKeySelective(model);
    }


    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Task model = new Task();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TaskConstants.STATUS.DELETED.num());
        return taskRespository.updateByPrimaryKeySelective(model);
    }

    public List<Task> list(Task taskParam, PageInfo pageInfo) {
        taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskRespository.listByClass(params);
    }

    public List<TaskResult> listByTaskOrTeacher(SelectTaskParam selectTaskParam, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        if(selectTaskParam.getUserId()!=null&&!"".equals(selectTaskParam.getUserId())){
            params.put("taskId", selectTaskParam.getTaskId());
        }
        if(selectTaskParam.getClassName()!=null&&!"".equals(selectTaskParam.getClassName())){
            params.put("className", "%"+selectTaskParam.getClassName()+"%");
        }
        if(selectTaskParam.getTeacherName()!=null&&!"".equals(selectTaskParam.getTeacherName())){
            params.put("teacherName", "%"+selectTaskParam.getTeacherName()+"%");
        }
        if(selectTaskParam.getTaskName()!=null&&!"".equals(selectTaskParam.getTaskName())){
            params.put("taskName", "%"+selectTaskParam.getTaskName()+"%");
        }
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskRespository.listByTaskOrTeacher(params);
    }

    public List<TaskResult> listByUser(User user, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("userId", user.getRecId());
        return taskRespository.listByUser(params);
    }

    public Integer countListByUser(User user) {
        return taskRespository.countListByUser(user.getRecId());
    }



    public Integer countListByTaskOrTeacher(SelectTaskParam selectTaskParam) {
        Map<String, Object> params = new HashMap<>();
        if(selectTaskParam.getUserId()!=null&&!"".equals(selectTaskParam.getUserId())){
            params.put("taskId", selectTaskParam.getTaskId());
        }
        if(selectTaskParam.getClassName()!=null&&!"".equals(selectTaskParam.getClassName())){
            params.put("className", "%"+selectTaskParam.getClassName()+"%");
        }
        if(selectTaskParam.getTeacherName()!=null&&!"".equals(selectTaskParam.getTeacherName())){
            params.put("teacherName", "%"+selectTaskParam.getTeacherName()+"%");
        }
        if(selectTaskParam.getTaskName()!=null&&!"".equals(selectTaskParam.getTaskName())){
            params.put("taskName", "%"+selectTaskParam.getTaskName()+"%");
        }
        return taskRespository.countListByTaskOrTeacher(params);
    }

    public Integer count(Task taskParam) {
        taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskParam);
        return taskRespository.count(params);
    }

}