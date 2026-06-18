package br.com.tksforge.resource.response;

import br.com.tksforge.domain.event.EventType;
import java.time.LocalDateTime;
import java.util.UUID;

/** DTO de resposta para expor informações públicas de um Event. */
public record EventResponse(
        UUID id,
        UUID participantId,
        EventType type,
        LocalDateTime occurredAt,
        String details
) {}
