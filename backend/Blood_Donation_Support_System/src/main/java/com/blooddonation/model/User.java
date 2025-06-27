//Entity người dùng
package com.blooddonation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; //Guest, Member, Staff,, Admin
    //Liên kết nhóm máu
    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    private String bloodGroup;

    @Column(nullable = false)
    private boolean readyToDonate;
}
