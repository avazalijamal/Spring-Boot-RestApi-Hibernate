package com.example.authdemo.model; // Paket adı

import jakarta.persistence.*; // JPA annotasiyaları üçün import

@Entity // Bu sinif verilənlər bazasında bir cədvələ (entity) uyğun gəlir
@Table(name = "users") // Cədvəl adı "users" olacaq
public class User {

    @Id // Bu sahə əsas açardır (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID avtomatik artırılır (auto-increment)
    private Long id; // İstifadəçinin unikal identifikatoru

    private String username; // İstifadəçi adı sütunu
    private String email;    // İstifadəçi emaili sütunu
    private String password; // İstifadəçi şifrəsi sütunu (adətən hash-lənmiş olur)

    // id üçün getter
    public Long getId() {
        return id;
    }

    // id üçün setter
    public void setId(Long id) {
        this.id = id;
    }

    // username üçün getter
    public String getUsername() {
        return username;
    }

    // username üçün setter
    public void setUsername(String username) {
        this.username = username;
    }

    // email üçün getter
    public String getEmail() {
        return email;
    }

    // email üçün setter
    public void setEmail(String email) {
        this.email = email;
    }

    // password üçün getter
    public String getPassword() {
        return password;
    }

    // password üçün setter
    public void setPassword(String password) {
        this.password = password;
    }
}
