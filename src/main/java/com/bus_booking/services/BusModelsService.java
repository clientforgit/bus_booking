package com.bus_booking.services;

import com.bus_booking.entities.BusModel;

public interface BusModelsService {
    void create(String name, int seatsNumber);
    Iterable<BusModel> readAll();
}
