package com.bus_booking.services.impl;

import com.bus_booking.entities.City;
import com.bus_booking.entities.Route;
import com.bus_booking.entities.Stop;
import com.bus_booking.repositories.CitiesRepository;
import com.bus_booking.repositories.RoutesRepository;
import com.bus_booking.repositories.StopsRepository;
import com.bus_booking.services.StopsService;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class StopsServiceImpl implements StopsService {

    private final RoutesRepository routesRepository;
    private final StopsRepository stopsRepository;
    private final CitiesRepository citiesRepository;

    public StopsServiceImpl(RoutesRepository routesRepository,
                            StopsRepository stopsRepository,
                            CitiesRepository citiesRepository) {
        this.routesRepository = routesRepository;
        this.stopsRepository = stopsRepository;
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(int routeId, int cityId, int dayShift, Time time, int price) {
        save(null, routeId, cityId, dayShift, time, price);
    }

    @Override
    public void update(int id, int routeId, int cityId, int dayShift, Time time, int price) {
        save(id, routeId, cityId, dayShift, time, price);
    }

    public void save(Integer id, int routeId, int cityId, int dayShift, Time time, int price) {
        Route route = routesRepository.findById(routeId).get();
        City city = citiesRepository.findById(cityId).get();
        Stop stop = id == null ? new Stop() : stopsRepository.findById(id).get();

        stop.setRoute(route);
        stop.setCity(city);
        stop.setDayShift(dayShift);
        stop.setTime(time);
        stop.setPrice(price);
        stopsRepository.saveAndFlush(stop);
    }

    @Override
    public void delete(int id) {
        stopsRepository.deleteById(id);
    }
}
