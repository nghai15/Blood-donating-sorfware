package com.example.blooddonation.service;

import com.example.blooddonation.model.BloodGroup;
import com.example.blooddonation.model.User;
import com.example.blooddonation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List; // <-- Dòng này cần được thêm vào
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (user.getLastDonation() == null) {
            user.setLastDonation(LocalDate.now().minusMonths(4));
        }
        return userRepository.save(user);
    }

    public List<User> findReadyDonors(BloodGroup bloodGroup) {
        return userRepository.findByReadyToDonateTrueAndBloodGroup(bloodGroup);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public String getDonationReadyStatus(User user) {
        if (user.isReadyToDonate()) {
            if (user.getLastDonation() != null) {
                long monthsSinceLastDonation = ChronoUnit.MONTHS.between(user.getLastDonation(), LocalDate.now());
                if (monthsSinceLastDonation < 3) {
                    return "Chưa sẵn sàng (" + (3 - monthsSinceLastDonation) + " tháng nữa)";
                }
            }
            return "Sẵn sàng";
        }
        return "Chưa sẵn sàng";
    }
}
