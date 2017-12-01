package de.conet.hack.realtime.chat.server.rest._common.filter;


import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * A Request Filter logging every request.
 * Used for debugging in develop-environment, not meant for production.
 */
@Provider
@RequestScoped
@Priority(FilterPriorities.LOGGING_REQUEST)
public class LoggingRequestFilter implements ContainerRequestFilter {

    @Inject
    protected Logger logger;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //Log request's: method + path + Accept + Content-Type
        logger.debug("Request: {} {} (accept: {}; content: {})",
                requestContext.getMethod(),
                requestContext.getUriInfo().getPath(),
                requestContext.getAcceptableMediaTypes(),
                requestContext.getMediaType()
        );
    }
}
