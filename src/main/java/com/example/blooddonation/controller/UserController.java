package com.example.blooddonation.controller;

import com.example.blooddonation.model.BloodGroup;
import com.example.blooddonation.model.User;
import com.example.blooddonation.model.Role;
import com.example.blooddonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List; // <-- Dòng này cần được thêm vào

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("bloodGroups", BloodGroup.values());
        model.addAttribute("roles", Role.values());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user,
                               @RequestParam(required = false) String lastDonationDateStr) {
        if (lastDonationDateStr != null && !lastDonationDateStr.isEmpty()) {
            try {
                user.setLastDonation(LocalDate.parse(lastDonationDateStr));
            } catch (Exception e) {
                user.setLastDonation(null);
            }
        } else {
            user.setLastDonation(LocalDate.now().minusMonths(4));
        }
        userService.registerUser(user);
        return "redirect:/donors?registered=true";
    }

    @GetMapping("/donors")
    public String listDonors(@RequestParam(required = false) BloodGroup bloodGroup, Model model) {
        List<User> donors;
        if (bloodGroup != null) {
            donors = userService.findReadyDonors(bloodGroup);
        } else {
            donors = userService.getAllUsers();
        }
        model.addAttribute("donors", donors);
        model.addAttribute("bloodGroups", BloodGroup.values());
        model.addAttribute("selectedBloodGroup", bloodGroup);
        model.addAttribute("userService", userService);
        return "donors";
    }
}
