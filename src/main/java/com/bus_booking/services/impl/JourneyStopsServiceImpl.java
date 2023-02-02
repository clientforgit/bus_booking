package com.bus_booking.services.impl;

import com.bus_booking.entities.JourneyStop;
import com.bus_booking.repositories.JourneyStopsRepository;
import com.bus_booking.services.JourneyStopsService;
import org.springframework.stereotype.Service;

@Service
public class JourneyStopsServiceImpl implements JourneyStopsService {
    private final JourneyStopsRepository journeyStopsRepository;

    public JourneyStopsServiceImpl(JourneyStopsRepository journeyStopsRepository) {
        this.journeyStopsRepository = journeyStopsRepository;
    }

    @Override
    public JourneyStop getByIds(int journeyId, int stopId) {
        return journeyStopsRepository.getJourneyStop(journeyId, stopId);
    }
}
