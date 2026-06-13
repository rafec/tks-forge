package br.com.tksforge.service;

import br.com.tksforge.domain.workout.Workout;
import br.com.tksforge.domain.workout.WorkoutStatus;
import br.com.tksforge.repository.WorkoutRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class WorkoutService {

  @Inject WorkoutRepository workoutRepository;

  @Transactional
  public Workout registerWorkout(
      UUID participantId, String photoUrl, String note, String workoutType) {

    Workout workout =
        new Workout(
            UUID.randomUUID(),
            participantId,
            LocalDate.now(),
            photoUrl,
            note,
            workoutType,
            WorkoutStatus.PENDING);

    workoutRepository.persist(workout);

    return workout;
  }

  public List<Workout> listWorkouts() {
    return workoutRepository.listAll();
  }
}
