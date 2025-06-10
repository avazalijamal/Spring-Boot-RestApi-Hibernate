package com.example.authdemo.service; // Paket adı

import com.example.authdemo.dto.UserLoginDto;    // Login üçün DTO (Data Transfer Object)
import com.example.authdemo.dto.UserRegisterDto; // Qeydiyyat üçün DTO
import com.example.authdemo.model.User;

public interface UserService {
    // İstifadəçi qeydiyyatı üçün metod
    // Parametr olaraq qeydiyyat məlumatlarını saxlayan UserRegisterDto alır
    // Geri dönüş olaraq String qaytarır (məsələn, status mesajı və ya token)
    String registerUser(UserRegisterDto userDto);

    // İstifadəçi login əməliyyatı üçün metod
    // Parametr olaraq login məlumatlarını saxlayan UserLoginDto alır
    // Geri dönüş olaraq String qaytarır (məsələn, token və ya status mesajı)
    String loginUser(UserLoginDto loginDto);
}
