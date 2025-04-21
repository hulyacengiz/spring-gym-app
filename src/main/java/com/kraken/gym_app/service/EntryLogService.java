package com.kraken.gym_app.service;

import com.kraken.gym_app.entity.EntryLog;
import com.kraken.gym_app.entity.User;
import com.kraken.gym_app.repository.EntryLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EntryLogService {

    private final EntryLogRepository entryLogRepository;

    public EntryLogService(EntryLogRepository entryLogRepository) {
        this.entryLogRepository = entryLogRepository;
    }

    public String attemptEntry(User user) {
        LocalDate today = LocalDate.now();

        boolean hasAlreadyEntered = entryLogRepository.existsByUserAndEntryDate(user, today);

        if (hasAlreadyEntered) {
            return "Bu kullanıcı bugün zaten giriş yapmış.";
        }

        EntryLog log = EntryLog.builder()
                .user(user)
                .entryDate(today)
                .build();

        entryLogRepository.save(log);
        return " Giriş kaydı başarılı!";
    }
}
