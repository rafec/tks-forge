package br.com.tksforge.domain.event;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Representa um acontecimento relevante ocorrido dentro da comunidade.
 *
 * <p>Eventos constituem o histórico imutável do sistema e devem ser utilizados para registrar toda
 * alteração significativa realizada por participantes ou administradores.
 *
 * <p>Os eventos são a principal fonte de verdade da aplicação, permitindo auditoria,
 * rastreabilidade e reconstrução do estado da comunidade.
 *
 * <p>Eventos nunca devem ser alterados ou removidos após sua criação. Correções devem ser
 * realizadas através da geração de novos eventos.
 */

/**
 * Futuramente eventos poderão referenciar entidades específicas através de identificadores
 * próprios, substituindo o campo details em alguns cenários.
 */
@Entity
@Table(name = "events")
public class Event {

  @Id private UUID id;

  private UUID participantId;

  @Enumerated(EnumType.STRING)
  private EventType type;

  private LocalDateTime occurredAt;

  private String details;

  public Event() {}

  public Event(
      UUID id, UUID participantId, LocalDateTime occurredAt, EventType type, String details) {
    this.id = id;
    this.participantId = participantId;
    this.type = type;
    this.occurredAt = occurredAt;
    this.details = details;
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

  public void setParticipantId(UUID participantId) {
    this.participantId = participantId;
  }

  public EventType getType() {
    return type;
  }

  public void setType(EventType type) {
    this.type = type;
  }

  public LocalDateTime getOccurredAt() {
    return occurredAt;
  }

  public void setOccurredAt(LocalDateTime occurredAt) {
    this.occurredAt = occurredAt;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
