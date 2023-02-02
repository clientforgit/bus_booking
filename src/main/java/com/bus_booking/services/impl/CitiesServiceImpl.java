package com.bus_booking.services.impl;

import com.bus_booking.entities.City;
import com.bus_booking.repositories.CitiesRepository;
import com.bus_booking.services.CitiesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    public final CitiesRepository citiesRepository;

    public CitiesServiceImpl(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(String name) {
        citiesRepository.saveAndFlush(new City(null, name));
    }

    @Override
    public List<City> readAll() {
        return citiesRepository.findAllByOrderByNameAsc();
    }

    @Override
    public void update(int id, String name) {
        City city = citiesRepository.findById(id).get();
        city.setName(name);
        citiesRepository.saveAndFlush(city);
    }

    @Override
    public void delete(Integer id) {
        citiesRepository.deleteById(id);
    }
}
