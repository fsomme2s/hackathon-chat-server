package de.conet.hack.realtime.chat.server.websockets.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.conet.hack.realtime.chat.server.rest._common.JacksonMapperResolver;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.websocket.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonEventDecoder implements Decoder.Text<BaseEvent>, Encoder.Text<BaseEvent> {

    private static Map<String, Class<? extends BaseEvent>> supportedClientEvents = new HashMap<>();
    static {
        supportedClientEvents.put(MessageEvent.EVENT_NAME, MessageEvent.class);
    }

    @Inject
    private Logger logger;

    @Inject
    private JacksonMapperResolver jacksonMapperResolver;

    private ObjectMapper mapper;

    private String eventType;

    @Override
    public void init(EndpointConfig ec) {
        mapper = this.jacksonMapperResolver.getContext();
    }

    @Override
    public void destroy() {
        logger.debug("Destroyed Decoder");
    }

    @Override
    public BaseEvent decode(String string) throws DecodeException {
        try {
            BaseEvent parsedEvent = mapper.readValue(string, supportedClientEvents.get(eventType));
            parsedEvent.setOriginalJson(string);
            return parsedEvent;
        } catch (IOException e) {
            throw new DecodeException(string, "Error Occured while unmarshalling json event", e);
        }
    }

    @Override
    public boolean willDecode(String string) {
        try {
            // Check, whether the sent eventType is supported:
            eventType = mapper.readTree(string).get("eventType").asText();
            return supportedClientEvents.containsKey(eventType);
        } catch (IOException e) {
            logger.debug(
                    "Error while decoding EventType for Decoder: {} - Websocket Message was: {}",
                    e.toString(),
                    string
            );
            return false;
        }
    }

    @Override
    public String encode(BaseEvent event) throws EncodeException {
        try {
            String s = mapper.writeValueAsString(event);
            return s;
        } catch (IOException e) {
            throw new EncodeException(event, "Error Occured while marshalling java event object to json", e);
        }
    }
}