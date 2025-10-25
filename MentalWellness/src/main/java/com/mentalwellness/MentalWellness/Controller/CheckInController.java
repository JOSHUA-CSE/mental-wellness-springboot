package com.mentalwellness.MentalWellness.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentalwellness.MentalWellness.Service.CheckInService;
import com.mentalwellness.MentalWellness.model.CheckIn;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController {
    @Autowired
    private CheckInService c_service;
    
    @GetMapping("/user/{id}")
    public String getAllCheckIns(@PathVariable Long id, Model model) {
        model.addAttribute("CheckIn", c_service.getAllCheckIns(id));
        return "checkIn/list";
    }
    
    @GetMapping("/new")
    public String createCheckInForm(Model model) {
        model.addAttribute("checkIn", new CheckIn());
        return "checkIn/form";
    }

    @PostMapping
    public String createCheckIn(@ModelAttribute CheckIn c) {
        c_service.createCheckIn(c);
        return "redirect:/api/checkin";
    }

}
