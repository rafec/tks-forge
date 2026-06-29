package br.com.tksforge.service;

import br.com.tksforge.domain.participant.ParticipantStats;
import br.com.tksforge.repository.ParticipantStatsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.util.UUID;

@ApplicationScoped
public class ParticipantStatsService {

  @Inject ParticipantStatsRepository participantStatsRepository;

  @Transactional
  public ParticipantStats registerInitialStats(UUID participantId) {
    ParticipantStats stats = ParticipantStats.createFor(participantId);
    participantStatsRepository.persist(stats);
    return stats;
  }

  @Transactional
  public ParticipantStats grantPointForApprovedWorkout(UUID participantId, LocalDate workoutDate) {
    ParticipantStats stats = participantStatsRepository.findById(participantId);

    if (stats == null) {
      throw new NotFoundException("Participant stats not found.");
    }

    stats.grantPoint();
    stats.registerWorkout(workoutDate);

    return stats;
  }

  public ParticipantStats getStats(UUID participantId) {
    ParticipantStats stats = participantStatsRepository.findById(participantId);

    if (stats == null) {
      throw new NotFoundException("Participant stats not found.");
    }

    return stats;
  }
}
