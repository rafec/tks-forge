package br.com.tksforge.domain.participant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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

  private UUID id;

  private String fullName;

  private String nickname;

  private LocalDate birthDate;

  private LocalDateTime joinedAt;

  @Enumerated(EnumType.STRING)
  private ParticipantStatus status;
}
