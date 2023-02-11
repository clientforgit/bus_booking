package com.bus_booking.models.admin;

import com.bus_booking.entities.Stop;
import com.bus_booking.entities.City;
import org.springframework.web.servlet.ModelAndView;

public class StopsModel extends ModelAndView {

    public StopsModel() {
        super("admin/stops");
    }

    public void setStops(Iterable<Stop> stops) {
        addObject("stops", stops);
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }

    public void setRouteId(Integer routeId) {
        addObject("routeId", routeId);
    }
}
