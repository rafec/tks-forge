package br.com.tksforge.resource;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.resource.request.CreateParticipantRequest;
import br.com.tksforge.resource.response.ParticipantResponse;
import jakarta.validation.Valid;
import br.com.tksforge.service.ParticipantService;
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
@Path("/participants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParticipantResource {

  @Inject ParticipantService participantService;

  @POST
  public Response create(@Valid CreateParticipantRequest request) {
    Participant participant =
        participantService.registerParticipant(
            request.fullName(), request.nickname(), request.birthDate());

    ParticipantResponse resp = toResponse(participant);
    URI location = UriBuilder.fromResource(ParticipantResource.class).path(participant.getId().toString()).build();
    return Response.created(location).entity(resp).build();
  }

  @GET
  public List<ParticipantResponse> listParticipants() {
    return participantService.listParticipants().stream()
        .map(ParticipantResource::toResponse)
        .collect(Collectors.toList());
  }

  private static ParticipantResponse toResponse(Participant p) {
    return new ParticipantResponse(
        p.getId(), p.getFullName(), p.getNickname(), p.getBirthDate(), p.getJoinedAt(), p.getStatus());
  }
}
