package com.synapse.reading.event.listener;


import com.synapse.reading.event.message.ClickLessonEvent;
import com.synapse.reading.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by wangyifan on 19-4-22.
 */
@Service
public class ClickLessonListener {

    private static Logger logger = LoggerFactory.getLogger(ClickLessonListener.class);

    @Autowired
    private LessonService lessonService;

    /**
     * 对课程点击事件进行处理
     *
     * @param event
     */
    @EventListener
    @Async("eventThread")
    public void processOffice(ClickLessonEvent event) {
        lessonService.addNum(event.getlessonId());
    }


}
