package com.bus_booking.models.admin;

import com.bus_booking.entities.Bus;
import com.bus_booking.entities.Driver;
import com.bus_booking.entities.Journey;
import com.bus_booking.entities.Route;
import org.springframework.web.servlet.ModelAndView;

public class JourneysModel extends ModelAndView {
    public JourneysModel() {
        super("/admin/journeys");
    }

    public void setJourneys(Iterable<Journey> journeys) {
        addObject("journeys", journeys);
    }

    public void setRoutes(Iterable<Route> routes) {
        addObject("routes", routes);
    }

    public void setBuses(Iterable<Bus> buses) {
        addObject("buses", buses);
    }

    public void setDrivers(Iterable<Driver> drivers) {
        addObject("drivers", drivers);
    }
}
