package de.conet.hack.realtime.chat.server.rest.status;

import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@RequestScoped
@Path(StatusApi.PATH)
public class StatusApi {

    public static final String PATH = "/status";

    @Inject
    private Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {
        return Response
                .ok(new StatusDto())
                .build();
    }
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response getStatusInPlainText() {
//        String statusMessageBuilder = "Service Status:\n\n"
//                + "General Status:\t\t"
//                + "UP"
//                ;
//
//        return Response
//                .ok(statusMessageBuilder)
//                .build();
//    }
}
