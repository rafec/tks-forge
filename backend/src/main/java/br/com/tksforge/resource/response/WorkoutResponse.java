package br.com.tksforge.resource.response;

import br.com.tksforge.domain.workout.WorkoutStatus;
import java.time.LocalDate;
import java.util.UUID;

/** DTO de resposta para expor informações públicas de um Workout. */
public record WorkoutResponse(
    UUID id,
    UUID participantId,
    LocalDate workoutDate,
    String photoUrl,
    String note,
    String workoutType,
    WorkoutStatus status) {}
