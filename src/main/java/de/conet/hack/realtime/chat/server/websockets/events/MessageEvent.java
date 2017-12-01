package de.conet.hack.realtime.chat.server.websockets.events;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * TODO jdoc
 */
public class MessageEvent extends BaseEvent {
    public static final String EVENT_NAME = "message";

    private String from;
    private String content;
    private LocalDateTime timeStamp;

    public MessageEvent() {
        super(EVENT_NAME);
    }

    public MessageEvent(String from, String content, LocalDateTime timeStamp) {
        super(EVENT_NAME);
        this.content = content;
        this.from = from;
        this.timeStamp = timeStamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "from='" + from + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
