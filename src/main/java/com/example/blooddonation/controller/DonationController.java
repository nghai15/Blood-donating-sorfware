package com.example.blooddonation.controller;

import com.example.blooddonation.model.BloodGroup;
import com.example.blooddonation.model.DonationRequest;
import com.example.blooddonation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/emergency_request")
    public String showEmergencyRequestForm(Model model) {
        model.addAttribute("donationRequest", new DonationRequest());
        model.addAttribute("bloodGroups", BloodGroup.values());
        return "emergency_request";
    }

    @PostMapping("/emergency_request")
    public String submitEmergencyRequest(@ModelAttribute DonationRequest donationRequest) {
        donationService.createDonationRequest(donationRequest);
        return "redirect:/emergency_request?success=true";
    }
}
