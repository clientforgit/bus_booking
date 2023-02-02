package com.bus_booking.services;

import com.bus_booking.entities.Bus;

public interface BusesService {
    void create(int modelId, String color, String licensePlateNumber);
    Iterable<Bus> readAll();
    void update(int id, int modelId, String color, String licensePlateNumber);
    void delete(int id);
}
