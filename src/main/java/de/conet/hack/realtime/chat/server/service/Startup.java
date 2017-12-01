package de.conet.hack.realtime.chat.server.service;

import de.conet.hack.realtime.chat.server.websockets.ChatRoomSocketEndpoint;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * TODO jdoc
 */
@Singleton
@javax.ejb.Startup
public class Startup {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager em;

    @Inject
    private ChatRoomSocketEndpoint chatRoomSocketEndpoint;

    @PostConstruct
    public void onStartup() {
        logger.debug("---------------------------------------------");
        logger.debug("Starting up!");
        logger.debug("---------------------------------------------");
    }
}
