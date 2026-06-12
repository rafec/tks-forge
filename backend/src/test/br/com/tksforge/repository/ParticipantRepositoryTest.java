package br.com.tksforge.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.tksforge.domain.participant.Participant;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ParticipantRepositoryTest {

  @Inject
  ParticipantRepository repository;

  @Test
  @Transactional
  void shouldPersistParticipant() {

    Participant participant = new Participant();

    participant.setId(UUID.randomUUID());
    participant.setFullName("Rafael Brizuena");
    participant.setNickname("Mestre Brizuena");

    repository.persist(participant);

    Participant persisted = repository.findById(participant.getId());

    assertNotNull(persisted);
  }
}
