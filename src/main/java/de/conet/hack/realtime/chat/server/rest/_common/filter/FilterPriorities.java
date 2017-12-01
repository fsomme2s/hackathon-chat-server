package de.conet.hack.realtime.chat.server.rest._common.filter;

/**
 * Listing the Priorities of {@link javax.ws.rs.container.ContainerRequestFilter}s.
 */
public class FilterPriorities {
    /** @see LoggingRequestFilter */
    public static final int LOGGING_REQUEST = 1;

//    /** @see AuthenticationFilter */
//    public static final int AUTHENTICATION = 2;

    /** @see CORSFilter */
    public static final int CORS = 3;
}
