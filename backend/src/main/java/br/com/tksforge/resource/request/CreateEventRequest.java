package br.com.tksforge.resource.request;

import br.com.tksforge.domain.event.EventType;
import java.util.UUID;

public record CreateEventRequest (UUID participantId, EventType type, String details) {}
