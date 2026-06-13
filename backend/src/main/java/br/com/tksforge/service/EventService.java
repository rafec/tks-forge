package br.com.tksforge.service;

import br.com.tksforge.domain.event.Event;
import br.com.tksforge.domain.event.EventType;
import br.com.tksforge.repository.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class EventService {

  @Inject EventRepository eventRepository;

  @Transactional
  public Event registerEvent(UUID participantId, EventType type, String details) {
    Event event = Event.create(participantId, type, details);
    eventRepository.persist(event);

    return event;
  }

  public List<Event> listEvents() {
    return eventRepository.listAll();
  }
}
