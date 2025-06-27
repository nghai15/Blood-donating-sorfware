package com.example.blooddonation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BloodGroup neededBloodGroup;

    private int quantity;
    private boolean emergency;
    private LocalDateTime requestTime;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;
}
