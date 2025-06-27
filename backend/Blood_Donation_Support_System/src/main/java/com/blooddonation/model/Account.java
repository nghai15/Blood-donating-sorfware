//Quản lý tài khoản đăng nhập
package com.blooddonation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String role;  // Guest, Member, Staff, Admin

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
