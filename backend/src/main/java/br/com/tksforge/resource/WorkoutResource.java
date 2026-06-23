package br.com.tksforge.resource;

import br.com.tksforge.domain.workout.Workout;
import br.com.tksforge.resource.request.CreateWorkoutRequest;
import br.com.tksforge.resource.response.WorkoutResponse;
import br.com.tksforge.service.WorkoutService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/workouts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorkoutResource {

  @Inject WorkoutService workoutService;

  @POST
  public Response create(@Valid CreateWorkoutRequest request) {
    Workout workout =
        workoutService.registerWorkout(
            request.participantId(), request.photoUrl(), request.note(), request.workoutType());

    WorkoutResponse resp = toResponse(workout);
    URI location =
        UriBuilder.fromResource(WorkoutResource.class).path(workout.getId().toString()).build();
    return Response.created(location).entity(resp).build();
  }

  @GET
  public List<WorkoutResponse> listWorkouts() {
    return workoutService.listWorkouts().stream()
        .map(WorkoutResource::toResponse)
        .collect(Collectors.toList());
  }

  @PATCH
  @Path("/{id}/approve")
  public WorkoutResponse approve(@PathParam("id") UUID workoutId) {
    Workout workout = workoutService.approveWorkout(workoutId);
    return toResponse(workout);
  }

  @PATCH
  @Path("/{id}/reject")
  public WorkoutResponse reject(@PathParam("id") UUID id) {
    Workout workout = workoutService.rejectWorkout(id);
    return toResponse(workout);
  }

  private static WorkoutResponse toResponse(Workout w) {
    return new WorkoutResponse(
        w.getId(),
        w.getParticipantId(),
        w.getWorkoutDate(),
        w.getPhotoUrl(),
        w.getNote(),
        w.getWorkoutType(),
        w.getStatus());
  }
}
