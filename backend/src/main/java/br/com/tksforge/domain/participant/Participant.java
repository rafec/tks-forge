package br.com.tksforge.domain.participant;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa um participante da comunidade TKS Forge.
 *
 * A entidade Participant deve conter apenas informações
 * inerentes à identidade do participante.
 *
 * Informações calculadas como pontos, streaks, rankings e
 * conquistas não devem ser armazenadas aqui.
 */
public class Participant {

    private UUID id;

    private String fullName;

    private String nickname;

    private LocalDate birthDate;

    private LocalDateTime joinedAt;

    private ParticipantStatus status;

}