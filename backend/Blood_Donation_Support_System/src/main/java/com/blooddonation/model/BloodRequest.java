//Yêu cầu cần máu, bao gồm khẩn cấp
package com.blooddonation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "blood_requests")
@Getter
@Setter
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    private BloodGroup bloodGroup;

    private int quantityNeeded;
    private boolean emergency;  // Đánh dấu trường hợp khẩn cấp
    private String location;

    private LocalDateTime requestTime;
}
