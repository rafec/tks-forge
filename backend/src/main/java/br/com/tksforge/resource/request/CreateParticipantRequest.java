package br.com.tksforge.resource.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

/**
 * DTO usado pelo resource para criar um participante.
 */
public record CreateParticipantRequest(
	@NotBlank(message = "fullName must not be blank") String fullName,
	String nickname,
	@NotNull(message = "birthDate is required") @Past(message = "birthDate must be in the past") LocalDate birthDate) {}
