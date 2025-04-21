package com.kraken.gym_app.service;

import com.kraken.gym_app.entity.User;
import com.kraken.gym_app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Bu kullanıcı adı zaten kayıtlı.";
        }

        // Hash password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "Kayıt başarılı.";
    }
}
