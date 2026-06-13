package br.com.tksforge.resource.request;

import java.util.UUID;

public record CreateWorkoutRequest(
    UUID participantId, String photoUrl, String note, String workoutType) {}
