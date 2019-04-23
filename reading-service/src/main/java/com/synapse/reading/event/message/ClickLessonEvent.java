package com.synapse.reading.event.message;


import org.springframework.context.ApplicationEvent;

/**
 * Created by wangyifan on 19-4-22.
 */
public class ClickLessonEvent extends ApplicationEvent {

    private String lessonId;

    public ClickLessonEvent(Object source, String lessonId) {
        super(source);
        this.lessonId = lessonId;
    }

    public String getlessonId() {
        return lessonId;
    }
}
