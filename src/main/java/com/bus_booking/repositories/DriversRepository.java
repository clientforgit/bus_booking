package com.bus_booking.repositories;


import com.bus_booking.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository extends JpaRepository<Driver, Integer> {
}
