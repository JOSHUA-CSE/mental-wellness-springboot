package com.mentalwellness.MentalWellness.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentalwellness.MentalWellness.Service.RecomendationService;
import com.mentalwellness.MentalWellness.model.Recomendation;


@RestController
@RequestMapping("/api/recomendation")
public class RecomendationController {
    @Autowired
    private RecomendationService r_service;
    
    @GetMapping("/user/{id}")
    public String getAllRecomendations(@PathVariable Long id, Model model) {
        model.addAttribute("Recomendation",r_service.getAllRecomendations(id));
        return "recomendation/list";
    }
    
    @GetMapping("/new")
    public String createRecomendationForm(Model model) {
        model.addAttribute("recomendation",new Recomendation());
        return "recomendation/form";
    }

    @PostMapping
    public String createRecomendation(@ModelAttribute Recomendation c) {
        r_service.createRecomendation(c);
        return "redirect:/api/recomendation";
    }
}
