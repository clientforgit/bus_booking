package com.bus_booking.models.admin;

import com.bus_booking.entities.Bus;
import com.bus_booking.entities.BusModel;
import org.springframework.web.servlet.ModelAndView;

public class BusesModel extends ModelAndView {
    public BusesModel() {
        super("/admin/buses");
    }

    public void setBuses(Iterable<Bus> buses) {
        addObject("buses", buses);
    }

    public void setBusModels(Iterable<BusModel> busModels) {
        addObject("bus_models", busModels);
    }
}
