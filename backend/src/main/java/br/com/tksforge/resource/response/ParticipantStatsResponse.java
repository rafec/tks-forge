package br.com.tksforge.resource.response;

import java.time.LocalDate;
import java.util.UUID;

public record ParticipantStatsResponse(
    UUID participantId, int currentPoints, int currentStreak, LocalDate lastWorkoutDate) {}
