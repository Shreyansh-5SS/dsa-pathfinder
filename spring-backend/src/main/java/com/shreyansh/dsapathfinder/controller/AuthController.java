package com.shreyansh.dsapathfinder.controller;

import com.shreyansh.dsapathfinder.model.User;
import com.shreyansh.dsapathfinder.model.UserLevel;
import com.shreyansh.dsapathfinder.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("levels", UserLevel.values());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already exists");
            model.addAttribute("levels", UserLevel.values());
            return "signup";
        }
        // learningStyle will be filled later by ML integration
        user.setLearningStyle(null);
        userRepository.save(user);
        model.addAttribute("name", user.getName());
        model.addAttribute("style", "UNKNOWN");
        return "welcome";
    }
}
