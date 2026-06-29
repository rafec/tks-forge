package br.com.tksforge.service;

import br.com.tksforge.domain.event.EventType;
import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.repository.ParticipantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ParticipantService {

  @Inject ParticipantRepository participantRepository;
  @Inject EventService eventService;
  @Inject ParticipantStatsService participantStatsService;

  @Transactional
  public Participant registerParticipant(String fullName, String nickname, LocalDate birthDate) {
    Participant participant = Participant.create(fullName, nickname, birthDate);
    participantRepository.persist(participant);

    participantStatsService.registerInitialStats(participant.getId());

    eventService.registerEvent(
        participant.getId(), EventType.PARTICIPANT_JOINED, "Participante ingressou na comunidade");

    return participant;
  }

  public List<Participant> listParticipants() {
    return participantRepository.listAll();
  }
}
