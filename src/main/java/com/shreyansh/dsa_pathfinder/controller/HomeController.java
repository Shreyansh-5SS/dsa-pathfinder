package com.shreyansh.dsa_pathfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    public String home(Model model) {
        model.addAttribute("title", "DSA Pathfinder");
        model.addAttribute("message", "It works!!");
        return "index";
    }
}