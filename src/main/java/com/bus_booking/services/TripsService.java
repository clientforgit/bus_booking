package com.bus_booking.services;

import com.bus_booking.entities.Trip;

import java.sql.Date;
import java.util.List;

public interface TripsService {
    List<Trip> getTrips(String from, String to, Date date);
    List<Trip> getAllTrips();
    int getPrice(Trip trip);
    int getPrice(int journeyId, int stopIdFrom, int stopIdTo);
}
