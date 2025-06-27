package com.example.blooddonation.repository;

import com.example.blooddonation.model.DonationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationHistoryRepository extends JpaRepository<DonationHistory, Long> {
}
