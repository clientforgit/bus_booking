package com.bus_booking.repositories;

import com.bus_booking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusesRepository extends JpaRepository<Bus, Integer> {
}
