package br.com.tksforge.resource;

import br.com.tksforge.domain.event.Event;
import br.com.tksforge.resource.request.CreateEventRequest;
import br.com.tksforge.service.EventService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

  @Inject EventService eventService;

  @POST
  public Event registerEvent(CreateEventRequest request) {
    return eventService.registerEvent(request.participantId(), request.type(), request.details());
  }

  @GET
    public List<Event> listEvents() {
        return eventService.listEvents();
    }
}
