package br.com.tksforge.resource;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.resource.request.CreateParticipantRequest;
import br.com.tksforge.resource.response.ParticipantResponse;
import br.com.tksforge.resource.response.ParticipantStatsResponse;
import br.com.tksforge.service.ParticipantService;
import br.com.tksforge.service.ParticipantStatsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/participants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParticipantResource {

  @Inject ParticipantService participantService;
  @Inject ParticipantStatsService participantStatsService;

  @POST
  public Response create(@Valid CreateParticipantRequest request) {
    Participant participant =
        participantService.registerParticipant(
            request.fullName(), request.nickname(), request.birthDate());

    ParticipantResponse resp = toResponse(participant);
    URI location =
        UriBuilder.fromResource(ParticipantResource.class)
            .path(participant.getId().toString())
            .build();
    return Response.created(location).entity(resp).build();
  }

  @GET
  public List<ParticipantResponse> listParticipants() {
    return participantService.listParticipants().stream()
        .map(ParticipantResource::toResponse)
        .collect(Collectors.toList());
  }

  @GET
  @Path("/{id}/stats")
  public ParticipantStatsResponse getStats(@PathParam("id") UUID participantId) {
    var stats = participantStatsService.getStats(participantId);

    return new ParticipantStatsResponse(
        stats.getParticipantId(),
        stats.getCurrentPoints(),
        stats.getCurrentStreak(),
        stats.getLastWorkoutDate());
  }

  private static ParticipantResponse toResponse(Participant p) {
    return new ParticipantResponse(
        p.getId(),
        p.getFullName(),
        p.getNickname(),
        p.getBirthDate(),
        p.getJoinedAt(),
        p.getStatus());
  }
}
