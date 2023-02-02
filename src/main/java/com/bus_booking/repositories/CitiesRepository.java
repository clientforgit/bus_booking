package com.bus_booking.repositories;


import com.bus_booking.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    List<City> findAllByOrderByNameAsc();
}
