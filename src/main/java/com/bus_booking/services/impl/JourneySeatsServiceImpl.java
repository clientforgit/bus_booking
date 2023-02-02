package com.bus_booking.services.impl;

import com.bus_booking.entities.Journey;
import com.bus_booking.entities.JourneyStop;
import com.bus_booking.repositories.JourneySeatsRepository;
import com.bus_booking.repositories.JourneyStopsRepository;
import com.bus_booking.repositories.JourneysRepository;
import com.bus_booking.services.JourneySeatsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneySeatsServiceImpl implements JourneySeatsService {

    private final JourneysRepository journeysRepository;
    private final JourneySeatsRepository journeySeatsRepository;
    private final JourneyStopsRepository journeyStopsRepository;

    public JourneySeatsServiceImpl(JourneysRepository journeysRepository,
                                   JourneySeatsRepository journeySeatsRepository,
                                   JourneyStopsRepository journeyStopsRepository) {
        this.journeysRepository = journeysRepository;
        this.journeySeatsRepository = journeySeatsRepository;
        this.journeyStopsRepository = journeyStopsRepository;
    }

    @Override
    public List<Integer> getAvailableSeats(int journeyId, int stopIdFrom, int stopIdTo) {
        Journey journey = journeysRepository.getReferenceById(journeyId);
        int seatsNumber = journey.getBus().getModel().getSeatsNumber();

        JourneyStop from = journeyStopsRepository.getJourneyStop(journeyId, stopIdFrom);
        JourneyStop to = journeyStopsRepository.getJourneyStop(journeyId, stopIdTo);

        List<Integer> availableSeats = new ArrayList<>();
        for (int i = 1; i <= seatsNumber; i++) {
            if (journeySeatsRepository.seatIsBusy(journeyId, i, from.getTimestamp(), to.getTimestamp()) == 0) {
                availableSeats.add(i);
            }
        }

        return availableSeats;
    }
}
