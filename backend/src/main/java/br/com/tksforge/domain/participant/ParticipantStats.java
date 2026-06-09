package br.com.tksforge.domain.participant;

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
public class ParticipantStats {

  private UUID participantId;

  private Integer currentPoints;

  private Integer currentStreak;

  private LocalDate lastWorkoutDate;
}
