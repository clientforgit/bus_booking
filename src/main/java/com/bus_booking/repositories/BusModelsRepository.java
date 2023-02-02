package com.bus_booking.repositories;

import com.bus_booking.entities.BusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusModelsRepository extends JpaRepository<BusModel, Integer> {
}
