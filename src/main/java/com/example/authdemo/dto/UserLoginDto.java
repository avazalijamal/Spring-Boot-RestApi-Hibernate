package com.example.authdemo.dto; // Paket adı

public class UserLoginDto { // Login üçün məlumat daşıyan DTO sinfi
    private String email; // İstifadəçinin email ünvanı
    private String password; // İstifadəçinin şifrəsi

    public String getEmail() {
        return email; // Email sahəsinin dəyərini qaytarır
    }

    public void setEmail(String email) {
        this.email = email; // Email sahəsinin dəyərini təyin edir
    }

    public String getPassword() {
        return password; // Şifrə sahəsinin dəyərini qaytarır
    }

    public void setPassword(String password) {
        this.password = password; // Şifrə sahəsinin dəyərini təyin edir
    }
}
