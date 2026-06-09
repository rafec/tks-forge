package br.com.tksforge.domain.workout;

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
public class Workout {

  private UUID id;

  private UUID participantId;

  private LocalDate workoutDate;

  private LocalDateTime submittedAt;

  private String photoUrl;

  private String note;

  private String workoutType;

  private WorkoutStatus status;

  /*private UUID approvedBy;

  private LocalDateTime approvedAt;*/

}
