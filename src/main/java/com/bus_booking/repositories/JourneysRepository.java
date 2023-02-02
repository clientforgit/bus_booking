package com.bus_booking.repositories;

import com.bus_booking.entities.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneysRepository extends JpaRepository<Journey, Integer> {
}
