package br.com.tksforge.service;

import br.com.tksforge.domain.event.EventType;
import br.com.tksforge.domain.workout.Workout;
import br.com.tksforge.repository.WorkoutRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class WorkoutService {

  @Inject WorkoutRepository workoutRepository;
  @Inject EventService eventService;
  @Inject ParticipantStatsService participantStatsService;

  @Transactional
  public Workout registerWorkout(
      UUID participantId, String photoUrl, String note, String workoutType) {
    Workout workout = Workout.create(participantId, photoUrl, note, workoutType);
    workoutRepository.persist(workout);

    eventService.registerEvent(
        participantId, EventType.WORKOUT_REGISTERED, "Treino registrado e aguardando aprovação");

    return workout;
  }

  public List<Workout> listWorkouts() {
    return workoutRepository.listAll();
  }

  @Transactional
  public Workout approveWorkout(UUID workoutId) {
    Workout workout = workoutRepository.findById(workoutId);

    if (workout == null) {
      throw new NotFoundException("Workout not found.");
    }

    workout.approve();

    eventService.registerEvent(
        workout.getParticipantId(), EventType.WORKOUT_APPROVED, "Workout approved.");

    eventService.registerEvent(
        workout.getParticipantId(), EventType.POINT_GRANTED, "Point granted for approved workout.");

    participantStatsService.grantPointForApprovedWorkout(
        workout.getParticipantId(), workout.getWorkoutDate());

    return workout;
  }

  @Transactional
  public Workout rejectWorkout(UUID workoutId) {
    Workout workout = workoutRepository.findById(workoutId);

    if (workout == null) {
      throw new NotFoundException("Workout not found.");
    }

    workout.reject();

    eventService.registerEvent(
        workout.getParticipantId(), EventType.WORKOUT_REJECTED, "Workout rejected.");

    return workout;
  }
}
