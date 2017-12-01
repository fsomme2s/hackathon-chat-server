package de.conet.hack.realtime.chat.server.rest.status;

import java.time.LocalDateTime;

/**
 * TODO jdoc
 */
public class StatusDto {
    private LocalDateTime serverTime = LocalDateTime.now();

    private String generalStatus = "UP";

    public LocalDateTime getServerTime() {
        return serverTime;
    }

    public void setServerTime(LocalDateTime serverTime) {
        this.serverTime = serverTime;
    }

    public String getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(String generalStatus) {
        this.generalStatus = generalStatus;
    }
}
