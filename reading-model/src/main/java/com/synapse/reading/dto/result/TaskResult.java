package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Task;
import com.synapse.reading.model.Video;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TaskResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@ApiModel(value = "TaskResult对象", description = "任务")
public class TaskResult {

    private Task task = new Task();

    private List<Book> bookList = new ArrayList<>();// 子列表

    private List<Lesson> lessonList = new ArrayList<>();// 子列表

    public TaskResult() {
    }

    public TaskResult(Task task) {
        this.task = task;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @JsonIgnore
    public Task getModel() {
        return task;
    }

    public void setModel(Task task) {
        this.task = task;
    }

    @ApiModelProperty(value = "")
    public String getRecId() {
        return task.getRecId();
    }

    public void setRecId(String rec_id) {
        task.setRecId(rec_id);
    }

    @ApiModelProperty(value = "任务名称")
    public String getName() {
        return task.getName();
    }

    public void setName(String name) {
        task.setName(name);
    }

    @ApiModelProperty(value = "任务描述")
    public String getIntro() {
        return task.getIntro();
    }

    public void setIntro(String intro) {
        task.setIntro(intro);
    }

    @ApiModelProperty(value = "学习相关类型")
    public String getStudyType() {
        return task.getStudyType();
    }

    public void setStudyType(String study_type) {
        task.setStudyType(study_type);
    }

    @ApiModelProperty(value = "学习相关id")
    public String getStudyId() {
        return task.getStudyId();
    }

    public void setStudyId(String study_id) {
        task.setStudyId(study_id);
    }

    @ApiModelProperty(value = "班级状态")
    public String getStatus() {
        return task.getStatus();
    }

    public void setStatus(String status) {
        task.setStatus(status);
    }

    @ApiModelProperty(value = "创建人")
    public String getCreateId() {
        return task.getCreateId();
    }

    public void setCreateId(String create_id) {
        task.setCreateId(create_id);
    }

    @ApiModelProperty(value = "创建时间")
    public String getCreateTime() {
        return task.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        task.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "更新人")
    public String getUpdateId() {
        return task.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        task.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "更新时间")
    public String getUpdateTime() {
        return task.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        task.setUpdateTime(update_time);
    }

    public String getClassId() {
        return task.getClassId();
    }

    public void setClassId(String classId) {
        task.setClassId(classId);
    }
}
