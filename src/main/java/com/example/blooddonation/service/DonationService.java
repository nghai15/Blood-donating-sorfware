package com.example.blooddonation.service;

import com.example.blooddonation.model.DonationHistory;
import com.example.blooddonation.model.DonationRequest;
import com.example.blooddonation.repository.DonationHistoryRepository;
import com.example.blooddonation.repository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List; 

@Service
public class DonationService {

    @Autowired
    private DonationRequestRepository requestRepository;

    @Autowired
    private DonationHistoryRepository historyRepository;

    public DonationRequest createDonationRequest(DonationRequest request) {
        request.setRequestTime(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public List<DonationRequest> getAllDonationRequests() {
        return requestRepository.findAll();
    }

    public DonationHistory recordDonation(DonationHistory history) {
        return historyRepository.save(history);
    }

    public List<DonationHistory> getAllDonationHistory() {
        return historyRepository.findAll();
    }
}
