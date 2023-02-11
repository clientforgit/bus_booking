package com.bus_booking.models.admin;

import com.bus_booking.entities.City;
import org.springframework.web.servlet.ModelAndView;

public class CitiesModel extends ModelAndView {

    public CitiesModel() {
        super("admin/cities");
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }

}
