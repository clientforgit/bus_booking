package com.bus_booking.repositories;

import com.bus_booking.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByJourneyId(int journeyId);
}
