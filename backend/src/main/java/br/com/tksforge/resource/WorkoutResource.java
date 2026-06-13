package br.com.tksforge.resource;

import br.com.tksforge.domain.workout.Workout;
import br.com.tksforge.repository.WorkoutRepository;
import br.com.tksforge.resource.request.CreateWorkoutRequest;
import br.com.tksforge.service.WorkoutService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/workouts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorkoutResource {

  @Inject WorkoutService workoutService;
  @Inject WorkoutRepository workoutRepository;

  @POST
  public Workout create(CreateWorkoutRequest request) {
    return workoutService.registerWorkout(
        request.participantId(), request.photoUrl(), request.note(), request.workoutType());
  }

  @GET
  public List<Workout> listWorkouts() {
    return workoutRepository.listAll();
  }
}
