package com.bus_booking.models.admin;

import com.bus_booking.entities.Journey;
import com.bus_booking.entities.Ticket;
import org.springframework.web.servlet.ModelAndView;

public class TicketsModel extends ModelAndView {

    public TicketsModel() {
        super("admin/tickets");
    }

    public void setTickets(Iterable<Ticket> tickets) {
        addObject("tickets", tickets);
    }
    public void setJourney(Journey journey) {
        addObject("journey", journey);
    }
}
