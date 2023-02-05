package com.bus_booking.services.impl;

import com.bus_booking.entities.*;
import com.bus_booking.repositories.JourneyStopsRepository;
import com.bus_booking.repositories.JourneysRepository;
import com.bus_booking.repositories.StopsRepository;
import com.bus_booking.repositories.TicketsRepository;
import com.bus_booking.services.TicketsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TicketsServiceImpl implements TicketsService {
    private final JourneysRepository journeysRepository;
    private final JourneyStopsRepository journeyStopsRepository;
    private final StopsRepository stopsRepository;
    private final TicketsRepository ticketsRepository;

    public TicketsServiceImpl(JourneysRepository journeysRepository,
                              JourneyStopsRepository journeyStopsRepository,
                              StopsRepository stopsRepository,
                              TicketsRepository ticketsRepository){
        this.journeysRepository = journeysRepository;
        this.journeyStopsRepository = journeyStopsRepository;
        this.stopsRepository = stopsRepository;
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public Ticket createInPendingStorage(String alias,
                                         String surname,
                                         String name,
                                         String phone,
                                         String email,
                                         int journeyId,
                                         int seatNumber,
                                         int stopIdFrom,
                                         int stopIdTo) {
        Journey journey = journeysRepository.getReferenceById(journeyId);
        Stop from = stopsRepository.getReferenceById(stopIdFrom);
        Stop to = stopsRepository.getReferenceById(stopIdTo);
        Ticket ticket = new Ticket(
                null,
                surname,
                name,
                phone,
                email,
                journey,
                seatNumber,
                from,
                to,
                journeyStopsRepository.getTripPrice(
                        journeyId,
                        journeyStopsRepository.getJourneyStop(journeyId, stopIdFrom).getTimestamp(),
                        journeyStopsRepository.getJourneyStop(journeyId, stopIdTo).getTimestamp()
                ),
                Timestamp.from(Instant.now())
        );
        return ticket;
    }

    @Override
    public void create(String surname, String name, String phone, String email,
                       int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        save(null, surname, name, phone, email, journeyId, seatNumber, stopNumberFrom, stopNumberTo, price);
    }

    @Override
    public void update(int id, String surname, String name, String phone, String email,
                       int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        save(id, surname, name, phone, email, journeyId, seatNumber, stopNumberFrom, stopNumberTo, price);
    }

    @Override
    public void delete(int id) {
        ticketsRepository.deleteById(id);
    }

    @Override
    public Iterable<Ticket> getByJourneyId(int journeyId) {
        return ticketsRepository.findAllByJourneyId(journeyId);
    }

    private void save(Integer id, String surname, String name, String phone, String email,
                      int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        Journey journey = journeysRepository.findById(journeyId).get();
        Stop stopFrom = stopsRepository.findById(stopNumberFrom).get();
        Stop stopTo = stopsRepository.findById(stopNumberTo).get();
        Ticket ticket = id == null ? new Ticket() : ticketsRepository.findById(id).get();

        ticket.setSurname(surname);
        ticket.setName(name);
        ticket.setPhone(phone);
        ticket.setEmail(email);
        ticket.setJourney(journey);
        ticket.setSeatNumber(seatNumber);
        ticket.setFrom(stopFrom);
        ticket.setTo(stopTo);
        ticket.setPrice(price);
        ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        ticketsRepository.saveAndFlush(ticket);
    }
}
