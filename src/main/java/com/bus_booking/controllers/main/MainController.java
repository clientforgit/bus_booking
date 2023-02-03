package com.bus_booking.controllers.main;


import com.bus_booking.models.MainModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView main() {
        return new MainModel();
    }
}
