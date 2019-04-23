package com.synapse.reading.event.listener;


import com.synapse.reading.event.message.ClickLessonEvent;
import com.synapse.reading.event.message.ClickVideoEvent;
import com.synapse.reading.service.LessonService;
import com.synapse.reading.service.VideoService;
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
public class ClickVideoListener {

    private static Logger logger = LoggerFactory.getLogger(ClickVideoListener.class);

    @Autowired
    private VideoService videoService;

    /**
     * 对视频点击事件进行处理
     *
     * @param event
     */
    @EventListener
    @Async("eventThread")
    public void processOffice(ClickVideoEvent event) {
        videoService.addPlayNum(event.getVideoId());
    }


}
