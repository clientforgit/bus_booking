package com.bus_booking.services;

import com.bus_booking.entities.JourneyStop;

public interface JourneyStopsService {
    JourneyStop getByIds(int journeyId, int stopId);
}
