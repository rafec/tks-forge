package br.com.tksforge.domain.workout;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa um registro de treino submetido por um participante.
 *
 * <p>Um treino é uma evidência de atividade física realizada e poderá ser aprovado ou rejeitado por
 * administradores de acordo com as regras da comunidade.
 *
 * <p>A aprovação de um treino pode gerar eventos como concessão de pontos, atualização de streaks,
 * obtenção de conquistas e demais alterações relevantes no estado do participante.
 *
 * <p>O treino não deve armazenar informações calculadas como pontuação, ranking ou streak atual.
 */
@Entity
@Table(name = "workouts")
public class Workout {

  @Id private UUID id;

  private UUID participantId;

  private LocalDate workoutDate;

  private String photoUrl;

  private String note;

  private String workoutType;

  @Enumerated(EnumType.STRING)
  private WorkoutStatus status;

  /*private UUID approvedBy;

  private LocalDateTime approvedAt;*/

  protected Workout() {}

  public Workout(UUID participantId, String photoUrl, String note, String workoutType) {
    this.participantId = participantId;
    this.photoUrl = photoUrl;
    this.note = note;
    this.workoutType = workoutType;
  }

  public static Workout create(
      UUID participantId, String photoUrl, String note, String workoutType) {
    Workout w = new Workout();
    w.id = UUID.randomUUID();
    w.workoutDate = LocalDate.now();
    w.status = WorkoutStatus.PENDING;

    return w;
  }

  @PrePersist
  void prePersist() {
    if (this.id == null) {
      this.id = UUID.randomUUID();
    }
    if (this.workoutDate == null) {
      this.workoutDate = LocalDate.now();
    }
    if (this.status == null) {
      this.status = WorkoutStatus.PENDING;
    }
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getParticipantId() {
    return participantId;
  }

  public void setParticipantId(UUID participantId) {}

  public LocalDate getWorkoutDate() {
    return workoutDate;
  }

  public void setWorkoutDate(LocalDate workoutDate) {
    this.workoutDate = workoutDate;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getWorkoutType() {
    return workoutType;
  }

  public void setWorkoutType(String workoutType) {
    this.workoutType = workoutType;
  }

  public WorkoutStatus getStatus() {
    return status;
  }

  public void setStatus(WorkoutStatus status) {
    this.status = status;
  }
}
