package br.com.tksforge.repository;

import br.com.tksforge.domain.workout.Workout;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class WorkoutRepository implements PanacheRepositoryBase<Workout, UUID> {}
