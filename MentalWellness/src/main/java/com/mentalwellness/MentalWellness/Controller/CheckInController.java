package com.mentalwellness.MentalWellness.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.mentalwellness.MentalWellness.Service.CheckInService;
import com.mentalwellness.MentalWellness.model.CheckIn;
import com.mentalwellness.MentalWellness.Service.UserService;

@Controller
@RequestMapping("/api/checkin")
public class CheckInController {
    @Autowired
    private CheckInService c_service;
    @Autowired
    private UserService userService;
    
    @GetMapping("/user/{id}")
    public String getAllCheckIns(@PathVariable Long id, Model model) {
        model.addAttribute("CheckIn",c_service.getAllCheckIns(id));
        return "checkin/list";
    }
    
    @GetMapping("/new")
    public String createCheckInForm(Model model) {
        model.addAttribute("checkIn",new CheckIn());
        model.addAttribute("users",userService.getAllUsers());
        return "checkin/form";
    }

    @PostMapping
    public String createCheckIn(@ModelAttribute CheckIn c) {
        c_service.createCheckIn(c);
        return "redirect:/api/checkin";
    }

    @GetMapping
    public String getAllCheckIns(Model model) {
        model.addAttribute("CheckIn",c_service.getAllCheckIns());
        return "checkin/list";
    }

}
