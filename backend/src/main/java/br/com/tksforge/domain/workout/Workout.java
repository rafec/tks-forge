package br.com.tksforge.domain.workout;


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