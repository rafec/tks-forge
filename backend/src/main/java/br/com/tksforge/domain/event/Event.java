package br.com.tksforge.domain.event;

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
public class Event {

  private UUID id;

  private UUID participantId;

  private EventType type;

  private LocalDateTime occurredAt;

  private String details;
}
