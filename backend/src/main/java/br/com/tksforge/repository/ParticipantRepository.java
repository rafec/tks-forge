package br.com.tksforge.repository;

import br.com.tksforge.domain.participant.Participant;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.UUID;

public class ParticipantRepository implements PanacheRepositoryBase<Participant, UUID> {}
