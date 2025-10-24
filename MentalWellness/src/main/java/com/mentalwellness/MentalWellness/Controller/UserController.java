package com.mentalwellness.MentalWellness.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentalwellness.MentalWellness.Service.UserService;
import com.mentalwellness.MentalWellness.model.User;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService u_service;
    
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", u_service.getAllUsers());
        return "user/list";
    }
    
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        u_service.createUser(user);
        return "redirect:/api/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", u_service.getUserById(id).orElseThrow());
        return "users/form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        u_service.updateUser(id, user);
        return "redirect:/api/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        u_service.deleteUser(id);
        return "redirect:/api/users";
    }
}
