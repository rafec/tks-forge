package br.com.tksforge.domain.participant;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Representa um participante da comunidade TKS Forge.
 *
 * <p>A entidade Participant deve conter apenas informações inerentes à identidade do participante.
 *
 * <p>Informações calculadas como pontos, streaks, rankings e conquistas não devem ser armazenadas
 * aqui.
 */
@Entity
@Table(name = "participants")
public class Participant {

  @Id private UUID id;

  private String fullName;

  private String nickname;

  private LocalDate birthDate;

  private LocalDateTime joinedAt;

  @Enumerated(EnumType.STRING)
  private ParticipantStatus status;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public LocalDateTime getJoinedAt() {
    return joinedAt;
  }

  public void setJoinedAt(LocalDateTime joinedAt) {
    this.joinedAt = joinedAt;
  }

  public ParticipantStatus getStatus() {
    return status;
  }

  public void setStatus(ParticipantStatus status) {
    this.status = status;
  }
}
