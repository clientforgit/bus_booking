package com.bus_booking.services;

import com.bus_booking.entities.Ticket;

public interface PendingTicketStorage {
    void addTicket(String alias, Ticket ticket);
    Ticket getTicket(String alias);
    void deleteTicket(String tempId);
}
