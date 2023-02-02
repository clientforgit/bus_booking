package com.bus_booking.controllers.admin;

import com.bus_booking.models.admin.RoutesModel;
import com.bus_booking.services.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutesController {

    private final RoutesService routesService;

    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @PostMapping("/admin/routes")
    public String create() {
        int id = routesService.create();
        return "redirect:/admin/stops?routeId=" + id;
    }

    @GetMapping("/admin/routes")
    public ModelAndView read() {
        RoutesModel model = new RoutesModel();
        model.setRoutes(routesService.readAll());
        return model;
    }

    @DeleteMapping("/admin/routes")
    public String delete(@RequestParam int id) {
        routesService.delete(id);
        return "redirect:/admin/routes";
    }
}
