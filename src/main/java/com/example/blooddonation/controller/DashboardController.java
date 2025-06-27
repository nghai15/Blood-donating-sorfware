package com.example.blooddonation.controller;

import com.example.blooddonation.model.BloodGroup;
import com.example.blooddonation.model.User;
import com.example.blooddonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.EnumMap;
import java.util.List; // <-- Dòng này cần được thêm vào
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<User> allUsers = userService.getAllUsers();
        int totalUsers = allUsers.size();
        int totalReadyDonors = 0;

        Map<BloodGroup, Integer> bloodGroupReadyCounts = new EnumMap<>(BloodGroup.class);
        for (BloodGroup bg : BloodGroup.values()) {
            bloodGroupReadyCounts.put(bg, 0);
        }

        for (User user : allUsers) {
            if (user.isReadyToDonate()) {
                totalReadyDonors++;
                bloodGroupReadyCounts.put(user.getBloodGroup(), bloodGroupReadyCounts.get(user.getBloodGroup()) + 1);
            }
        }

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalReadyDonors", totalReadyDonors);
        model.addAttribute("bloodGroupReadyCounts", bloodGroupReadyCounts);
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("userService", userService);

        return "dashboard";
    }
}
