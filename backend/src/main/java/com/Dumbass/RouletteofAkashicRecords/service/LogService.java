package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.domain.Log;
import com.Dumbass.RouletteofAkashicRecords.domain.Subject;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.repository.log.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void save(User user, Subject subject ) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        Log log = new Log(user, currentDateTime, subject);
        logRepository.saveLog(log);
    }
}
