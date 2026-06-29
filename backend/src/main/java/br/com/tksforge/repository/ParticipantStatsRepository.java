package br.com.tksforge.repository;

import br.com.tksforge.domain.participant.ParticipantStats;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ParticipantStatsRepository implements PanacheRepositoryBase<ParticipantStats, UUID> {}
