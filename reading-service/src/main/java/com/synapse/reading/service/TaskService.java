package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.constants.LessonConstants;
import com.synapse.reading.dto.param.ClassTaskStudyParam;
import com.synapse.reading.dto.param.SelectTaskParam;
import com.synapse.reading.model.*;
import com.synapse.reading.respository.*;
import com.synapse.reading.dto.param.TaskParam;
import com.synapse.reading.dto.result.TaskResult;
import com.synapse.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TaskConstants;
import com.synapse.reading.remote.IdService;
import sun.reflect.generics.repository.ClassRepository;

import java.text.SimpleDateFormat;
import java.util.*;
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
    @Autowired
    private MemberRespository memberRespository;
    @Autowired
    private ClassInfoRespository classInfoRespository;
    @Autowired
    private TaskNoteRespository taskNoteRespository;


    private Logger logger = LoggerFactory.getLogger(TaskService.class);

    public Task find(String recId) {
        return taskRespository.selectByPrimaryKey(recId);
    }

    public TaskResult findByStudy(String recId) {
        TaskResult taskResult = taskRespository.selectTask(recId);
        List<String> lessonIds = taskStudyMappingService.getStudyIds(recId, "lesson");
        logger.warn("------------------lessonIds=" + lessonIds);
        if (lessonIds != null && lessonIds.size() > 0) {
            List<Lesson> lessons = lessonService.listByLessonIds(lessonIds);
            logger.warn("------------------lessons=" + lessons);
            if (lessons != null && lessons.size() > 0) {
                taskResult.setLessonList(lessons);
            }
        }
        List<String> bookIds = taskStudyMappingService.getStudyIds(recId, "book");
        logger.warn("------------------bookIds=" + bookIds);
        if (bookIds != null && bookIds.size() > 0) {
            List<Book> books = bookService.listByBookIds(bookIds);
            logger.warn("------------------books=" + books);
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

    public List<TaskResult> list(Task taskParam, PageInfo pageInfo) {
        taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskRespository.listByClass(params);
    }

    public List<TaskResult> listByTaskOrTeacher(String startTime, String endTime, String classId) {
        Map<String, Object> params = new HashMap<>();
        if (startTime != null && !"".equals(startTime)) {
            params.put("startTime", startTime);
        }
        if (endTime != null && !"".equals(endTime)) {
            params.put("endTime", endTime);
        }
        if (classId != null && !"".equals(classId)) {
            params.put("classId", classId);
        }
        return taskRespository.listByTaskOrTeacher(params);
    }

    public List<TaskResult> listByUser(User user, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("userId", user.getRecId());
        return taskRespository.listByUser(params);
    }

    public Map<String, String> listByCountAllData(User user) throws Exception {
        Member member = memberRespository.selectByUserId(user.getRecId());
        Map<String, String> map = new HashMap<>();
        if (member != null && !"".equals(member)) {
            map = taskRespository.listByCountAllData(member.getOrganization());
        }
        return map;
    }


    public List<Map<String, Object>> listByCountData(User user, String startTime, String endTime, String teacherId, String classId, String taskId) throws Exception {
        Member member = memberRespository.selectByUserId(user.getRecId());
        Map<String, Object> params = new HashMap<>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("teacherId", teacherId);
        params.put("classId", classId);
        params.put("taskId", taskId);
        List<Map<String, Object>> dataList = new ArrayList<>();
        List<String> monthList = getMonthBetweenDates(startTime, endTime);

        if (member != null && !"".equals(member)) {
            params.put("organization", member.getOrganization());
            List<Map<String, String>> teacherList = memberRespository.countTeacherNum(params);

            List<Map<String, String>> classList = classInfoRespository.countClassNum(params);

            List<Map<String, String>> taskList = taskRespository.countTaskNum(params);

            List<Map<String, String>> finishList = taskNoteRespository.countFinishNum(params);

            if (monthList != null && monthList.size() > 0) {

                for (String data : monthList) {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("year", data);
                    if (teacherList != null && teacherList.size() > 0) {
                        for (Map<String, String> teacher : teacherList) {
                            if (teacher.get("time") != null && data.equals(teacher.get("time"))) {
                                dataMap.put("teacherNum", teacher.get("teacherNum"));
                            } else {
                                dataMap.put("teacherNum", 0);
                            }
                        }
                    }
                    if (classList != null && classList.size() > 0) {
                        for (Map<String, String> classInfo : classList) {
                            if (classInfo.get("time") != null && data.equals(classInfo.get("time"))) {
                                dataMap.put("classNum", classInfo.get("classNum"));
                            } else {
                                dataMap.put("classNum", 0);
                            }
                        }
                    }
                    if (taskList != null && taskList.size() > 0) {
                        for (Map<String, String> task : taskList) {
                            if (task.get("time") != null && data.equals(task.get("time"))) {
                                dataMap.put("taskNum", task.get("taskNum"));
                            } else {
                                dataMap.put("taskNum", 0);
                            }
                        }
                    }
                    if (finishList != null && finishList.size() > 0) {
                        for (Map<String, String> finish : finishList) {
                            if (finish.get("time") != null && data.equals(finish.get("time"))) {
                                dataMap.put("finishNum", finish.get("finishNum"));
                            } else {
                                dataMap.put("finishNum", 0);
                            }
                        }
                    }
                    dataList.add(dataMap);
                }
            }

        }
        return dataList;
    }


    public Integer countListByUser(User user) {
        return taskRespository.countListByUser(user.getRecId());
    }


    public Integer countListByTaskOrTeacher(SelectTaskParam selectTaskParam) {
        Map<String, Object> params = new HashMap<>();
        if (selectTaskParam.getUserId() != null && !"".equals(selectTaskParam.getUserId())) {
            params.put("taskId", selectTaskParam.getTaskId());
        }
        if (selectTaskParam.getClassName() != null && !"".equals(selectTaskParam.getClassName())) {
            params.put("className", "%" + selectTaskParam.getClassName() + "%");
        }
        if (selectTaskParam.getTeacherName() != null && !"".equals(selectTaskParam.getTeacherName())) {
            params.put("teacherName", "%" + selectTaskParam.getTeacherName() + "%");
        }
        if (selectTaskParam.getTaskName() != null && !"".equals(selectTaskParam.getTaskName())) {
            params.put("taskName", "%" + selectTaskParam.getTaskName() + "%");
        }
        return taskRespository.countListByTaskOrTeacher(params);
    }

    public Integer count(Task taskParam) {
        taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskParam);
        return taskRespository.count(params);
    }

    /**
     * 获取某个时间段内所有月份
     */
    public List<String> getMonthBetweenDates(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM").parse(minDate);//定义起始日期

            Date d2 = new SimpleDateFormat("yyyy-MM").parse(maxDate);//定义结束日期

            Calendar dd = Calendar.getInstance();//定义日期实例

            dd.setTime(d1);//设置日期起始时间

            while (dd.getTime().before(d2)) {//判断是否到结束日期

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

                String str = sdf.format(dd.getTime());

                result.add(str);

                dd.add(Calendar.MONTH, 1);//进行当前日期月份加1

            }
            return result;
        } catch (Exception e) {
            return result;
        }
    }


}