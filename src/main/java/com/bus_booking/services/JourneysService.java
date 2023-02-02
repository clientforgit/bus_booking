package com.bus_booking.services;

import com.bus_booking.entities.Journey;

import java.sql.Date;

public interface JourneysService {
    void create(int routeId, int busId, int driverId, Date startDate);
    Iterable<Journey> readAll();
    Journey readById(int id);
    void update(int id, int routeId, int busId, int driverId, Date startDate);
    void delete(int id);
}
