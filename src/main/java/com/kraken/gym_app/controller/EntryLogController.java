package com.kraken.gym_app.controller;

import com.kraken.gym_app.entity.User;
import com.kraken.gym_app.repository.UserRepository;
import com.kraken.gym_app.service.EntryLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EntryLogController {

    private final UserRepository userRepository;
    private final EntryLogService entryLogService;

    public EntryLogController(UserRepository userRepository, EntryLogService entryLogService) {
        this.userRepository = userRepository;
        this.entryLogService = entryLogService;
    }

    @PostMapping("/entry")
    public ResponseEntity<String> enterGym(@RequestParam String username) {
        User user = userRepository.findByUsername(username)
                .orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body("Kullanıcı bulunamadı.");
        }

        String result = entryLogService.attemptEntry(user);
        return ResponseEntity.ok(result);
    }
}
