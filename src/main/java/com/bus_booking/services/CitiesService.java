package com.bus_booking.services;

import com.bus_booking.entities.City;

import java.util.List;

public interface CitiesService {
    void create(String name);
    List<City> readAll();
    void update(int id, String name);
    void delete(Integer id);
}
