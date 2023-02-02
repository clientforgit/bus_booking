package com.bus_booking.services;


import com.bus_booking.entities.Ticket;

public interface TicketsService {
    Ticket createInPendingStorage(String alias, String surname, String name, String phone, String email,
                                  int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo);

    void create(String surname, String name, String phone, String email,
                int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price);

    Iterable<Ticket> getByJourneyId(int journeyId);

    void update(int id, String surname, String name, String phone, String email,
                int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price);

    void delete(int id);
}
