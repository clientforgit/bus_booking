package com.bus_booking.models.admin;

import com.bus_booking.entities.Route;
import org.springframework.web.servlet.ModelAndView;

public class RoutesModel extends ModelAndView {

    public RoutesModel() {
        super("/admin/routes");
    }

    public void setRoutes(Iterable<Route> routes) {
        addObject("routes", routes);
    }
}
