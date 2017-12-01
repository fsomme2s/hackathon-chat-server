package de.conet.hack.realtime.chat.server.websockets.events;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

/**
 * TODO jdoc
 */
public abstract class BaseEvent {

    @JsonIgnore
    private String originalJson;

    private String eventType;


    public BaseEvent(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getOriginalJson() {
        return originalJson;
    }

    public void setOriginalJson(String originalJson) {
        this.originalJson = originalJson;
    }

}
