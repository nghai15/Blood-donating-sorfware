//Quản lý thông tin nhóm máu
package com.blooddonation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blood_groups")
@Getter
@Setter
public class BloodGroup {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;  // Ví dụ: A+, A-, B+, O+, AB+ ...
}
