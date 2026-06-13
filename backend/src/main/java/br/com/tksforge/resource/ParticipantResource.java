package br.com.tksforge.resource;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.resource.request.CreateParticipantRequest;
import br.com.tksforge.service.ParticipantService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

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

  @GET
  public List<Participant> listParticipants() {
    return participantService.listParticipants();
  }
}
