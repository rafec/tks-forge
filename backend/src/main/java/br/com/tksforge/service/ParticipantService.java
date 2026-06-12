package br.com.tksforge.service;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.domain.participant.ParticipantStatus;
import br.com.tksforge.repository.ParticipantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class ParticipantService {

  @Inject ParticipantRepository participantRepository;

  @Transactional
  public Participant registerParticipant(String fullName, String nickname, LocalDate birthDate) {

    Participant participant =
        new Participant(
            UUID.randomUUID(),
            fullName,
            nickname,
            birthDate,
            LocalDateTime.now(),
            ParticipantStatus.ACTIVE);

    participantRepository.persist(participant);

    return participant;
  }
}
