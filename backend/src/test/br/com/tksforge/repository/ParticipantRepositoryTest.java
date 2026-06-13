package br.com.tksforge.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.tksforge.domain.participant.Participant;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ParticipantRepositoryTest {

  @Inject
  ParticipantRepository repository;

  @Test
  @Transactional
  void shouldPersistParticipant() {

    Participant participant = new Participant("Rafael Brizuena", "Bobera", LocalDate.of(2002, 8, 13));

    repository.persist(participant);

    Participant persisted = repository.findById(participant.getId());

    assertNotNull(persisted);
  }
}
