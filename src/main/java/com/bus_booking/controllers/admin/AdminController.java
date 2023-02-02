package com.bus_booking.controllers.admin;

import com.bus_booking.models.admin.AdminModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new AdminModel();
    }
}
