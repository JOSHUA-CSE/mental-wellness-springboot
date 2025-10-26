package com.mentalwellness.MentalWellness.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.mentalwellness.MentalWellness.Service.RecomendationService;
import com.mentalwellness.MentalWellness.Service.UserService;
import com.mentalwellness.MentalWellness.model.Recomendation;


@Controller
@RequestMapping("/api/recomendation")
public class RecomendationController {
    @Autowired
    private RecomendationService r_service;
    
    @Autowired
    private UserService u_service;
    
    @GetMapping("/user/{id}")
    public String getAllRecomendations(@PathVariable Long id, Model model) {
        model.addAttribute("recomendations", r_service.getAllRecomendations(id));
        return "recomendation/list";
    }

    @GetMapping
    public String getAllRecomendations(Model model) {
        model.addAttribute("recomendations", r_service.getAllRecomendations());
        return "recomendation/list";
    }
    
    @GetMapping("/new")
    public String createRecomendationForm(Model model) {
        model.addAttribute("rec",new Recomendation());
        model.addAttribute("users",u_service.getAllUsers());
        return "recomendation/form";
    }

    @PostMapping
    public String createRecomendation(@ModelAttribute("rec") Recomendation c) {
        Recomendation saved=r_service.createRecomendation(c);
        if (saved!=null&& saved.getUser()!=null&& saved.getUser().getUser_id()!=null) {
            return "redirect:/api/recomendation/user/"+saved.getUser().getUser_id();
        }
        return "redirect:/api/recomendation/new";
    }
}
