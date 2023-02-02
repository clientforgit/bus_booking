package com.bus_booking.services.impl;

import com.bus_booking.entities.Bus;
import com.bus_booking.entities.Driver;
import com.bus_booking.entities.Journey;
import com.bus_booking.entities.Route;
import com.bus_booking.repositories.BusesRepository;
import com.bus_booking.repositories.DriversRepository;
import com.bus_booking.repositories.JourneysRepository;
import com.bus_booking.repositories.RoutesRepository;
import com.bus_booking.services.JourneysService;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class JourneysServiceImpl implements JourneysService {

    private final JourneysRepository journeysRepository;
    private final RoutesRepository routesRepository;
    private final BusesRepository busesRepository;
    private final DriversRepository driversRepository;

    public JourneysServiceImpl(JourneysRepository journeysRepository,
                               RoutesRepository routesRepository,
                               BusesRepository busesRepository,
                               DriversRepository driversRepository) {
        this.journeysRepository = journeysRepository;
        this.routesRepository = routesRepository;
        this.busesRepository = busesRepository;
        this.driversRepository = driversRepository;
    }

    @Override
    public void create(int routeId, int busId, int driverId, Date startDate) {
        Route route = routesRepository.findById(routeId).get();
        Bus bus = busesRepository.findById(busId).get();
        Driver driver = driversRepository.findById(driverId).get();
        journeysRepository.saveAndFlush(new Journey(null, route, bus, driver, startDate));
    }

    @Override
    public Iterable<Journey> readAll() {
        return journeysRepository.findAll();
    }

    @Override
    public Journey readById(int id) {
        return journeysRepository.findById(id).get();
    }

    @Override
    public void update(int id, int routeId, int busId, int driverId, Date startDate) {
        Journey journey = journeysRepository.findById(id).get();
        journey.setRoute(routesRepository.findById(routeId).get());
        journey.setBus(busesRepository.findById(busId).get());
        journey.setDriver(driversRepository.findById(driverId).get());
        journey.setStartDate(startDate);
        journeysRepository.saveAndFlush(journey);
    }

    @Override
    public void delete(int id) {
        journeysRepository.deleteById(id);
    }
}
