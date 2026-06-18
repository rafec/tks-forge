package br.com.tksforge.resource;

import br.com.tksforge.domain.event.Event;
import br.com.tksforge.resource.request.CreateEventRequest;
import br.com.tksforge.resource.response.EventResponse;
import br.com.tksforge.service.EventService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

  @Inject EventService eventService;

  @POST
  public Response create(CreateEventRequest request) {
    Event event =
        eventService.registerEvent(request.participantId(), request.type(), request.details());

    EventResponse resp = toResponse(event);
    URI location =
        UriBuilder.fromResource(EventResource.class).path(event.getId().toString()).build();
    return Response.created(location).entity(resp).build();
  }

  @GET
  public List<EventResponse> listEvents() {
    return eventService.listEvents().stream()
        .map(EventResource::toResponse)
        .collect(Collectors.toList());
  }

  private static EventResponse toResponse(Event e) {
    return new EventResponse(
        e.getId(), e.getParticipantId(), e.getType(), e.getOccurredAt(), e.getDetails());
  }
}
