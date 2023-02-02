package com.bus_booking.services.impl;

import com.bus_booking.entities.BusModel;
import com.bus_booking.repositories.BusModelsRepository;
import com.bus_booking.services.BusModelsService;
import org.springframework.stereotype.Service;

@Service
public class BusModelsServiceImpl implements BusModelsService {

    private final BusModelsRepository busModelsRepository;

    private BusModelsServiceImpl(BusModelsRepository busModelsRepository) {
        this.busModelsRepository = busModelsRepository;
    }

    @Override
    public void create(String name, int seatsNumber) {
        busModelsRepository.saveAndFlush(new BusModel(null, name, seatsNumber));
    }

    @Override
    public Iterable<BusModel> readAll() {
        return busModelsRepository.findAll();
    }
}
