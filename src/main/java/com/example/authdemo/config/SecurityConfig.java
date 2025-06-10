package com.example.authdemo.config; // Paket adı

import org.springframework.context.annotation.Bean; // Bean annotasiyası üçün import
import org.springframework.context.annotation.Configuration; // Configuration annotasiyası üçün import
import org.springframework.security.config.Customizer; // Security konfiqurasiya üçün import
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // HTTP təhlükəsizlik üçün import
import org.springframework.security.web.SecurityFilterChain; // Təhlükəsizlik filterləri üçün import

@Configuration // Bu sinif Spring konfiqurasiya sinifidir
public class SecurityConfig {

    @Bean // Spring konteynerinə SecurityFilterChain bean olaraq əlavə edilir
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF (Cross Site Request Forgery) qorumasını deaktiv edir (Postman və test üçün rahatlıq)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // "/api/auth/**" ilə başlayan URL-lərə hamıya icazə verilir (login, register)
                        .anyRequest().authenticated() // Qalan bütün sorğular üçün istifadəçi doğrulaması tələb olunur
                )

                .httpBasic(Customizer.withDefaults()); // HTTP Basic Authentication istifadə edilir (username/password ilə sadə doğrulama)

        return http.build(); // Təhlükəsizlik filter zəncirini yaradır və qaytarır
    }
}
