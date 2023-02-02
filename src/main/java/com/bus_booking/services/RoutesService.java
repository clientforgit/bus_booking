package com.bus_booking.services;

import com.bus_booking.entities.Route;
import com.bus_booking.entities.Stop;

public interface RoutesService {
    int create();
    Iterable<Route> readAll();
    Iterable<Stop> getRouteStops(int routeId);
    void delete(int id);
}
