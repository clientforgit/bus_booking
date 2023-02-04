package com.bus_booking.services.impl;

import com.bus_booking.entities.Journey;
import com.bus_booking.entities.Stop;
import com.bus_booking.entities.Trip;
import com.bus_booking.entities.TripPrimaryKey;
import com.bus_booking.repositories.JourneyStopsRepository;
import com.bus_booking.repositories.JourneysRepository;
import com.bus_booking.repositories.StopsRepository;
import com.bus_booking.repositories.TripsRepository;
import com.bus_booking.services.TripsService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TripsServiceImpl implements TripsService {

    private final TripsRepository tripsRepository;
    private final JourneyStopsRepository journeyStopsRepository;
    private final JourneysRepository journeysRepository;
    private final StopsRepository stopsRepository;

    public TripsServiceImpl(TripsRepository tripsRepository,
                            JourneyStopsRepository journeyStopsRepository,
                            JourneysRepository journeysRepository,
                            StopsRepository stopsRepository) {
        this.tripsRepository = tripsRepository;
        this.journeyStopsRepository = journeyStopsRepository;
        this.journeysRepository = journeysRepository;
        this.stopsRepository = stopsRepository;
    }

    public List<Trip> getTrips(String from, String to, Date date) {
        return tripsRepository.findByCitiesAndDepartureDate(from, to, date);
    }

    public List<Trip> getAllTrips() {
        return tripsRepository.findAll();
    }

    public int getPrice(Trip trip) {
        return journeyStopsRepository.getTripPrice(
                trip.getId().getJourney().getId(),
                trip.getFromTimestamp(),
                trip.getToTimestamp()
        );
    }

    @Override
    public int getPrice(int journeyId, int stopIdFrom, int stopIdTo) {
        Journey journey = journeysRepository.getReferenceById(journeyId);
        Stop from = stopsRepository.getReferenceById(stopIdFrom);
        Stop to = stopsRepository.getReferenceById(stopIdTo);

        Trip trip = tripsRepository.getReferenceById(new TripPrimaryKey(journey, from, to));
        return getPrice(trip);
    }

    public List<Integer> getFreeSeats(Trip trip) {
        return null;
    }
}
