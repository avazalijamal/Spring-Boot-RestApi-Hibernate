package com.example.authdemo.service;

import com.example.authdemo.dto.UserLoginDto;
import com.example.authdemo.dto.UserRegisterDto;
import com.example.authdemo.model.User;
import com.example.authdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Şifrəni hash-ləmək üçün
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Bu sinif Service kimi Spring konteynerində qeyd olunur
public class UserServiceImpl implements UserService {

    @Autowired // Avtomatik olaraq UserRepository bean-in inject olunması
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // Şifrə hash-ləmə və yoxlama üçün BCryptPasswordEncoder nümunəsi yaradılır

    @Override
    public String registerUser(UserRegisterDto userDto) {
        // Email-ə görə artıq qeydiyyatda olan istifadəçini tapmağa çalışırıq
        Optional<User> existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser.isPresent()) {
            return "Email artıq qeydiyyatdan keçib!"; // Əgər varsa, xəbərdarlıq mesajı qaytarır
        }

        // Yeni istifadəçi yaradılır və DTO-dan məlumatlar qoyulur
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // Şifrə BCrypt ilə hash-lənərək saxlanılır (təhlükəsizlik üçün)

        userRepository.save(user); // İstifadəçi verilənlər bazasına qeyd olunur

        return "Qeydiyyat uğurla tamamlandı!"; // Uğur mesajı qaytarılır
    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        // Email-ə əsasən istifadəçini tapmağa çalışırıq
        Optional<User> userOpt = userRepository.findByEmail(loginDto.getEmail());

        if (userOpt.isEmpty()) {
            return "İstifadəçi tapılmadı!"; // İstifadəçi yoxdursa xəbərdarlıq mesajı qaytarır
        }

        User user = userOpt.get();
        // Verilən şifrə ilə saxlanılan hash-lənmiş şifrə uyğunluğunu yoxlayırıq
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return "Şifrə yanlışdır!"; // Şifrə səhvdirsə xəbərdarlıq mesajı qaytarır
        }

        return "Giriş uğurludur!"; // Uğurlu giriş mesajı qaytarır
    }
}
