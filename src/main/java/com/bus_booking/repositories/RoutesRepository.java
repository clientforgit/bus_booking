package com.bus_booking.repositories;


import com.bus_booking.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<Route, Integer> {
}
