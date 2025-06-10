package com.example.authdemo.controller; // Paket adı

import com.example.authdemo.dto.UserLoginDto; // İstifadəçi login məlumatlarını daşıyan DTO
import com.example.authdemo.dto.UserRegisterDto; // İstifadəçi qeydiyyat məlumatlarını daşıyan DTO
import com.example.authdemo.service.UserService; // İstifadəçi biznes loqikasını yerinə yetirən service
import org.springframework.beans.factory.annotation.Autowired; // Avtomatik bean inject üçün import
import org.springframework.web.bind.annotation.*; // REST Controller annotasiyaları üçün import

@RestController // Bu sinif REST controller kimi işləyir, JSON qaytarır
@RequestMapping("/api/auth") // Bütün endpoint-lər "/api/auth" prefiksi ilə başlayır
public class AuthController {

    @Autowired // Spring avtomatik olaraq UserService bean-in inject edir
    private UserService userService;

    @PostMapping("/register") // POST sorğusu "/api/auth/register" URL üçün
    public String register(@RequestBody UserRegisterDto userDto) {
        // Sorğunun gövdəsində gələn JSON-u UserRegisterDto obyektinə çevirir
        return userService.registerUser(userDto); // Qeydiyyat əməliyyatını service-ə ötürür, nəticəni qaytarır
    }

    @PostMapping("/login") // POST sorğusu "/api/auth/login" URL üçün
    public String login(@RequestBody UserLoginDto loginDto) {
        // Sorğunun gövdəsində gələn JSON-u UserLoginDto obyektinə çevirir
        return userService.loginUser(loginDto); // Login əməliyyatını service-ə ötürür, nəticəni qaytarır
    }
}
