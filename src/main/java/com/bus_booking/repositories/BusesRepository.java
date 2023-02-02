package com.bus_booking.repositories;

import com.bus_booking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusesRepository extends JpaRepository<Bus, Integer> {
}
