package com.example.authdemo.dto; // Paket adı

public class UserRegisterDto {
    private String username;  // İstifadəçinin adı, qeydiyyat üçün
    private String email;     // İstifadəçinin emaili, qeydiyyat üçün
    private String password;  // İstifadəçinin şifrəsi, qeydiyyat üçün

    // username üçün getter metodu
    public String getUsername() {
        return username;
    }

    // username üçün setter metodu
    public void setUsername(String username) {
        this.username = username;
    }

    // email üçün getter metodu
    public String getEmail() {
        return email;
    }

    // email üçün setter metodu
    public void setEmail(String email) {
        this.email = email;
    }

    // password üçün getter metodu
    public String getPassword() {
        return password;
    }

    // password üçün setter metodu
    public void setPassword(String password) {
        this.password = password;
    }
}
