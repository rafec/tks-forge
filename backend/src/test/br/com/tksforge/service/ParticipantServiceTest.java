package br.com.tksforge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.tksforge.domain.participant.Participant;
import br.com.tksforge.repository.ParticipantRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ParticipantServiceTest {

  @Inject ParticipantService service;

  @Inject ParticipantRepository repository;

  @Test
  @Transactional
  void shouldRegisterParticipant() {

    Participant participant =
        service.registerParticipant("Rafael Brizuena", "Mestre Brizuena", LocalDate.of(1995, 1, 1));

    Participant persisted = repository.findById(participant.getId());

    assertNotNull(persisted);
    assertEquals("Mestre Brizuena", persisted.getNickname());
  }
}
