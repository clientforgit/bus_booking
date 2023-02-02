package com.bus_booking.repositories;

import com.bus_booking.entities.Trip;
import com.bus_booking.entities.TripPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface TripsRepository extends JpaRepository<Trip, TripPrimaryKey> {
    @Query(value = """
                   SELECT *
                    FROM trips
                    WHERE
                        from_city_name = ? AND
                        to_city_name = ? AND
                        DATE(from_timestamp) = ?
                   """, nativeQuery = true)
    List<Trip> findByCitiesAndDepartureDate(String from, String to, Date departureDate);
}
