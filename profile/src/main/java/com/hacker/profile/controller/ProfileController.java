package com.hacker.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hacker.profile.entity.Profile;
import com.hacker.profile.service.ProfileService;

import org.springframework.ui.Model;




@Controller
public class ProfileController {
    @Autowired
    private ProfileService service;

    @GetMapping("/apply")
    public String showForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "index.html";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Profile profile) {
        service.saveProfile(profile);
        return "confirmation.html";
    }
}