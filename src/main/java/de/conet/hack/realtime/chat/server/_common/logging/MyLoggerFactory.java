package de.conet.hack.realtime.chat.server._common.logging;


import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * CDI Factory for SLF4J Logger.
 */
@ApplicationScoped
public class MyLoggerFactory {

    @Produces
    public Logger createLogger(final InjectionPoint ip){
        return createLogger(ip.getMember().getDeclaringClass());
    }

    public static Logger createLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }

}
