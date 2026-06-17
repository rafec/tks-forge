package br.com.tksforge.resource.response;

import br.com.tksforge.domain.participant.ParticipantStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/** DTO de resposta para expor informações públicas de um Participant. */
public record ParticipantResponse(
    UUID id,
    String fullName,
    String nickname,
    LocalDate birthDate,
    LocalDateTime joinedAt,
    ParticipantStatus status) {}

