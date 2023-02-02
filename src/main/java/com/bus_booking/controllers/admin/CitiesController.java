package com.bus_booking.controllers.admin;

import com.bus_booking.models.admin.CitiesModel;
import com.bus_booking.services.CitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CitiesController {

    private final CitiesService citiesService;

    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @PostMapping("/admin/cities")
    public String create(@RequestParam String name) {
        citiesService.create(name);
        return "redirect:/admin/cities";
    }

    @GetMapping("/admin/cities")
    public ModelAndView read() {
        CitiesModel citiesModel = new CitiesModel();
        citiesModel.setCities(citiesService.readAll());
        return citiesModel;
    }

    @PatchMapping("/admin/cities")
    public String update(@RequestParam Integer id, @RequestParam String name) {
        citiesService.update(id, name);
        return "redirect:/admin/cities";
    }

    @DeleteMapping("/admin/cities")
    public String delete(@RequestParam Integer id) {
        citiesService.delete(id);
        return "redirect:/admin/cities";
    }
}
