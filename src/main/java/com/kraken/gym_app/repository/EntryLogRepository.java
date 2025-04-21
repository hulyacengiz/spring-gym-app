package com.kraken.gym_app.repository;

import com.kraken.gym_app.entity.EntryLog;
import com.kraken.gym_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EntryLogRepository extends JpaRepository<EntryLog, Long> {
    boolean existsByUserAndEntryDate(User user, LocalDate entryDate);
}