package de.conet.hack.realtime.chat.server.rest._common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Producing the {@link ObjectMapper Jackson ObjectMapper} instance which should be used by Jax-RS to
 * consume/produce JSON.
 * <p>
 * 	<b>Use this to configure the ObjectMapper for all resources.</b>
 * </p>
 */
@Provider
@ApplicationScoped
public class JacksonMapperResolver implements ContextResolver<ObjectMapper> {

    @Inject
    protected Logger logger;

    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        /* Creating the ObjectMapper inside postconstruct; this way, it will be instantiated and configured
         * exactly one time, when the first resource is loaded.
         * ! Not using the constructor as we don't have dependencies injected there !
         */
        logger.info("Creating configured Jackson Object Mapper.");
        createObjectMapper();
    }

    private void createObjectMapper() {
        this.mapper = new ObjectMapper();

        //find the JSR310 data type module of jackson (marshalling Java 8 DateTime API):
        mapper.findAndRegisterModules();

        //render DateTimes not as array of attributes ([2017,1,29,...]) but as String ('2017-01-29...'):
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //do not render null values:
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

    public ObjectMapper getContext() {
        return mapper;
    }
}
