package br.com.tksforge.domain.participant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa o estado atual calculado de um participante.
 *
 * <p>As estatísticas são derivadas do histórico de eventos registrados no sistema e existem para
 * otimizar consultas frequentes, como ranking, perfil e acompanhamento de progresso.
 *
 * <p>Esta entidade não constitui a fonte principal da verdade. A fonte principal da verdade
 * permanece sendo o histórico de eventos da aplicação.
 */
@Entity
@Table(name = "participant_stats")
public class ParticipantStats {

  @Id private UUID participantId;

  private Integer currentPoints;

  private Integer currentStreak;

  private LocalDate lastWorkoutDate;

  protected ParticipantStats() {}

  public ParticipantStats(UUID participantId) {
    this.participantId = participantId;
    this.currentPoints = 0;
    this.currentStreak = 0;
    this.lastWorkoutDate = null;
  }

  public static ParticipantStats createFor(UUID participantId) {
    return new ParticipantStats(participantId);
  }

  public void grantPoint() {
    this.currentPoints++;
  }

  // não entendi a lógica aqui
  public void registerWorkout(LocalDate workoutDate) {
    if (this.lastWorkoutDate == null || workoutDate.isAfter(this.lastWorkoutDate)) {
      this.lastWorkoutDate = workoutDate;
    }
  }

  public UUID getParticipantId() {
    return participantId;
  }

  public int getCurrentPoints() {
    return currentPoints;
  }

  public int getCurrentStreak() {
    return currentStreak;
  }

  public LocalDate getLastWorkoutDate() {
    return lastWorkoutDate;
  }
}
