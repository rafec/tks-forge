package br.com.tksforge.resource;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.resource.request.CreateParticipantRequest;
import br.com.tksforge.service.ParticipantService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/participants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParticipantResource {

  @Inject ParticipantService participantService;

  @POST
  public Participant create(CreateParticipantRequest request) {
    return participantService.registerParticipant(
        request.fullName(), request.nickname(), request.birthDate());
  }
}
