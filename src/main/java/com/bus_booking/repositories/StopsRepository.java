package com.bus_booking.repositories;

import com.bus_booking.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepository extends JpaRepository<Stop, Integer> {

}
