package com.example.authdemo.repository; // Paket adı

import com.example.authdemo.model.User; // User modelini import edir
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA interfeysi import edilir
import java.util.Optional; // Optional sinfi import edilir

public interface UserRepository extends JpaRepository<User, Long> {
    // User üçün verilənlər bazası əməliyyatları üçün JpaRepository-ni genişləndirir
    // Long burada User-un ID tipidir

    Optional<User> findByEmail(String email);
    // Email üzrə istifadəçini tapmaq üçün metod (Spring Data JPA ad-əsaslı sorğu yaradır)
    // Optional ilə əgər tapılmazsa null yox, Optional.empty() qaytarılır
}
