package br.com.tksforge.service;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.repository.ParticipantRepository;
import jakarta.inject.Inject;

public class ParticipantService {

  @Inject ParticipantRepository participantRepository;

  public Participant registerParticipant() {}
}
