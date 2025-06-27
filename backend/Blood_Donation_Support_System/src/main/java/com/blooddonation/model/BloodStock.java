//Kho máu của cơ sở y tế
package com.blooddonation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "blood_stock")
@Getter
@Setter
public class BloodStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    private BloodGroup bloodGroup;

    @Column(nullable = false)
    private int quantity;  // Đơn vị tính có thể là ml hoặc đơn vị túi máu
}
