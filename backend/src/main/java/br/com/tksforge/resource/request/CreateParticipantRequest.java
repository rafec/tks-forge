package br.com.tksforge.resource.request;

import java.time.LocalDate;

public record CreateParticipantRequest(String fullName, String nickname, LocalDate birthDate) {}
