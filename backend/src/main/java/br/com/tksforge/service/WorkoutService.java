package br.com.tksforge.service;

import br.com.tksforge.domain.event.EventType;
import br.com.tksforge.domain.workout.Workout;
import br.com.tksforge.repository.WorkoutRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class WorkoutService {

  @Inject WorkoutRepository workoutRepository;
  @Inject EventService eventService;

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
}
