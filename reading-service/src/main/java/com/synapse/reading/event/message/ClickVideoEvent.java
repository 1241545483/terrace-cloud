package com.synapse.reading.event.message;


import org.springframework.context.ApplicationEvent;

/**
 * Created by wangyifan on 19-4-22.
 */
public class ClickVideoEvent extends ApplicationEvent {

    private String videoId;

    public ClickVideoEvent(Object source, String videoId) {
        super(source);
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }
}
