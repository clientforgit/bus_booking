package com.bus_booking.models.admin;

import com.bus_booking.entities.Driver;
import org.springframework.web.servlet.ModelAndView;

public class DriversModel extends ModelAndView {
    public DriversModel() {
        super("/admin/drivers");
    }

    public void setDrivers(Iterable<Driver> drivers) {
        addObject("drivers", drivers);
    }
}
