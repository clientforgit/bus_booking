package com.bus_booking.controllers.main;

import com.bus_booking.models.OrderTicketModel;
import com.bus_booking.services.JourneySeatsService;
import com.bus_booking.services.TripsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderTicketController {

    private final TripsService tripsService;
    private final JourneySeatsService journeySeatsService;

    public OrderTicketController(TripsService tripsService,
                                 JourneySeatsService journeySeatsService) {
        this.tripsService = tripsService;
        this.journeySeatsService = journeySeatsService;
    }

    @PostMapping("/orderTicket")
    public ModelAndView orderTicket(@RequestParam int journeyId,
                                    @RequestParam int stopIdFrom,
                                    @RequestParam int stopIdTo) {
        OrderTicketModel orderTicketModel = new OrderTicketModel();
        orderTicketModel.setPrice(tripsService.getPrice(journeyId, stopIdFrom, stopIdTo));
        orderTicketModel.setAvailableSeats(journeySeatsService.getAvailableSeats(journeyId, stopIdFrom, stopIdTo));
        orderTicketModel.setJourneyId(journeyId);
        orderTicketModel.setStopIdFrom(stopIdFrom);
        orderTicketModel.setStopIdTo(stopIdTo);
        return orderTicketModel;
    }
}
